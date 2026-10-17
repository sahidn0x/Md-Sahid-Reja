package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.CoreSubjectsData
import com.example.data.DsaData
import com.example.data.PlacementData
import com.example.data.ProjectsCareersData
import com.example.data.SpecializationsData
import com.example.data.UniversityData
import com.example.data.ai.ChatMessage
import com.example.data.ai.GeminiAiService
import com.example.data.local.LearningRepository
import com.example.model.DsaStatus
import com.example.model.RecentHistoryItem
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

enum class ScreenTab(val title: String) {
    HOME("Home"),
    AI_TUTOR("AI Tutor"),
    ACADEMICS("Academics"),
    CORE_CSE("Core CSE"),
    SPECIALIZATIONS("Specializations"),
    DSA_PRACTICE("DSA Tracks"),
    PLACEMENT("Placement"),
    PROJECTS("Projects"),
    CAREERS("Careers"),
    MY_LEARNING("My Learning"),
    ABOUT("About")
}

data class SearchResult(
    val id: String,
    val title: String,
    val subtitle: String,
    val category: String,
    val targetTab: ScreenTab,
    val targetItemId: String? = null
)

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = LearningRepository(application)

    private val _currentTab = MutableStateFlow(ScreenTab.HOME)
    val currentTab: StateFlow<ScreenTab> = _currentTab.asStateFlow()

    private val _selectedSubjectCode = MutableStateFlow(UniversityData.subjects.first().code)
    val selectedSubjectCode: StateFlow<String> = _selectedSubjectCode.asStateFlow()

    private val _selectedCourseId = MutableStateFlow(CoreSubjectsData.courses.first().id)
    val selectedCourseId: StateFlow<String> = _selectedCourseId.asStateFlow()

    private val _selectedSpecializationId = MutableStateFlow(SpecializationsData.list.first().id)
    val selectedSpecializationId: StateFlow<String> = _selectedSpecializationId.asStateFlow()

    private val _selectedProjectId = MutableStateFlow(ProjectsCareersData.blueprints.first().id)
    val selectedProjectId: StateFlow<String> = _selectedProjectId.asStateFlow()

    private val _dsaTrack = MutableStateFlow("Normal")
    val dsaTrack: StateFlow<String> = _dsaTrack.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _isSearchDialogOpen = MutableStateFlow(false)
    val isSearchDialogOpen: StateFlow<Boolean> = _isSearchDialogOpen.asStateFlow()

    private val _isSubmitDialogOpen = MutableStateFlow(false)
    val isSubmitDialogOpen: StateFlow<Boolean> = _isSubmitDialogOpen.asStateFlow()

    val bookmarks: StateFlow<Set<String>> = repository.bookmarks
    val dsaStatusMap: StateFlow<Map<String, DsaStatus>> = repository.dsaStatusMap
    val recentHistory: StateFlow<List<RecentHistoryItem>> = repository.recentHistory

    private val geminiService = GeminiAiService(application)

    private val _chatMessages = MutableStateFlow<List<ChatMessage>>(
        listOf(
            ChatMessage(
                id = "welcome",
                role = "model",
                content = "Namaste! I am your CSE Compass AI Tutor, powered by Gemini. Ask me about any Computer Science concept, university syllabus unit (AKTU), coding challenge, or placement interview question! Select a topic above to focus our discussion."
            )
        )
    )
    val chatMessages: StateFlow<List<ChatMessage>> = _chatMessages.asStateFlow()

    private val _isAiThinking = MutableStateFlow(false)
    val isAiThinking: StateFlow<Boolean> = _isAiThinking.asStateFlow()

    private val _selectedChatTopic = MutableStateFlow("All CSE Topics")
    val selectedChatTopic: StateFlow<String> = _selectedChatTopic.asStateFlow()

    private val _aiErrorMessage = MutableStateFlow<String?>(null)
    val aiErrorMessage: StateFlow<String?> = _aiErrorMessage.asStateFlow()

    val userApiKey: String
        get() = geminiService.getUserCustomApiKey()

    val searchResults: StateFlow<List<SearchResult>> = _searchQuery.combine(_currentTab) { query, _ ->
        if (query.isBlank()) return@combine emptyList<SearchResult>()
        val q = query.trim().lowercase()
        val results = mutableListOf<SearchResult>()

        if (q.contains("ai") || q.contains("gemini") || q.contains("tutor") || q.contains("doubt") || q.contains("chat") || q.contains("ask")) {
            results.add(
                SearchResult(
                    id = "ai-tutor",
                    title = "AI CSE Tutor (Gemini 3.5 Flash)",
                    subtitle = "Ask any CSE question, code explanation, or exam doubt",
                    category = "AI Assistant",
                    targetTab = ScreenTab.AI_TUTOR
                )
            )
        }

        // 1. University Subjects & Units
        UniversityData.subjects.forEach { sub ->
            if (sub.name.lowercase().contains(q) || sub.code.lowercase().contains(q) || sub.summary.lowercase().contains(q)) {
                results.add(
                    SearchResult(
                        id = sub.code,
                        title = "${sub.code}: ${sub.name}",
                        subtitle = "Semester ${sub.semester} • AKTU Syllabus",
                        category = "University Subject",
                        targetTab = ScreenTab.ACADEMICS,
                        targetItemId = sub.code
                    )
                )
            }
            sub.units.forEach { u ->
                if (u.unitTitle.lowercase().contains(q) || u.topics.any { it.lowercase().contains(q) }) {
                    results.add(
                        SearchResult(
                            id = "${sub.code}-u${u.unitNumber}",
                            title = "${sub.name} - Unit ${u.unitNumber}: ${u.unitTitle}",
                            subtitle = "Topics: ${u.topics.take(2).joinToString(", ")}",
                            category = "Academic Unit",
                            targetTab = ScreenTab.ACADEMICS,
                            targetItemId = sub.code
                        )
                    )
                }
            }
        }

        // 2. Core Programming Courses
        CoreSubjectsData.courses.forEach { course ->
            if (course.name.lowercase().contains(q) || course.designatedProvider.lowercase().contains(q) ||
                course.orderedTopics.any { it.lowercase().contains(q) }
            ) {
                results.add(
                    SearchResult(
                        id = course.id,
                        title = course.name,
                        subtitle = "Provider: ${course.designatedProvider} (${course.language.label})",
                        category = "Core Programming",
                        targetTab = ScreenTab.CORE_CSE,
                        targetItemId = course.id
                    )
                )
            }
        }

        // 3. Specializations
        SpecializationsData.list.forEach { spec ->
            if (spec.title.lowercase().contains(q) || spec.tagline.lowercase().contains(q)) {
                results.add(
                    SearchResult(
                        id = spec.id,
                        title = spec.title,
                        subtitle = spec.tagline,
                        category = "Specialization",
                        targetTab = ScreenTab.SPECIALIZATIONS,
                        targetItemId = spec.id
                    )
                )
            }
        }

        // 4. DSA Problems
        DsaData.problems.forEach { prob ->
            if (prob.title.lowercase().contains(q) || prob.topic.lowercase().contains(q)) {
                results.add(
                    SearchResult(
                        id = prob.id,
                        title = prob.title,
                        subtitle = "${prob.topic} • ${prob.difficulty.label} • Track ${prob.track}",
                        category = "DSA Problem",
                        targetTab = ScreenTab.DSA_PRACTICE,
                        targetItemId = prob.id
                    )
                )
            }
        }

        results.take(12)
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun navigateTo(tab: ScreenTab, itemId: String? = null) {
        _currentTab.value = tab
        if (itemId != null) {
            when (tab) {
                ScreenTab.ACADEMICS -> _selectedSubjectCode.value = itemId
                ScreenTab.CORE_CSE -> _selectedCourseId.value = itemId
                ScreenTab.SPECIALIZATIONS -> _selectedSpecializationId.value = itemId
                ScreenTab.PROJECTS -> _selectedProjectId.value = itemId
                ScreenTab.DSA_PRACTICE -> {
                    // Check if problem is in FAANG or Normal
                    val p = DsaData.problems.find { it.id == itemId }
                    if (p != null) {
                        _dsaTrack.value = p.track
                    }
                }
                else -> Unit
            }
        }
    }

    fun selectSubject(code: String) {
        _selectedSubjectCode.value = code
        val sub = UniversityData.subjects.find { it.code == code }
        if (sub != null) {
            repository.recordVisit(
                RecentHistoryItem(
                    id = sub.code,
                    title = "${sub.code}: ${sub.name}",
                    category = "University Subject",
                    tabTag = ScreenTab.ACADEMICS.name
                )
            )
        }
    }

    fun selectCourse(id: String) {
        _selectedCourseId.value = id
        val c = CoreSubjectsData.courses.find { it.id == id }
        if (c != null) {
            repository.recordVisit(
                RecentHistoryItem(
                    id = c.id,
                    title = c.name,
                    category = "Core Programming",
                    tabTag = ScreenTab.CORE_CSE.name
                )
            )
        }
    }

    fun selectSpecialization(id: String) {
        _selectedSpecializationId.value = id
        val s = SpecializationsData.list.find { it.id == id }
        if (s != null) {
            repository.recordVisit(
                RecentHistoryItem(
                    id = s.id,
                    title = s.title,
                    category = "Specialization Track",
                    tabTag = ScreenTab.SPECIALIZATIONS.name
                )
            )
        }
    }

    fun selectProject(id: String) {
        _selectedProjectId.value = id
        val p = ProjectsCareersData.blueprints.find { it.id == id }
        if (p != null) {
            repository.recordVisit(
                RecentHistoryItem(
                    id = p.id,
                    title = p.title,
                    category = "Project Blueprint",
                    tabTag = ScreenTab.PROJECTS.name
                )
            )
        }
    }

    fun setDsaTrack(track: String) {
        _dsaTrack.value = track
    }

    fun toggleBookmark(id: String) {
        repository.toggleBookmark(id)
    }

    fun isBookmarked(id: String): Boolean {
        return repository.isBookmarked(id)
    }

    fun setDsaStatus(problemId: String, status: DsaStatus) {
        repository.setDsaStatus(problemId, status)
    }

    fun setSearchQuery(q: String) {
        _searchQuery.value = q
    }

    fun openSearchDialog() {
        _isSearchDialogOpen.value = true
    }

    fun closeSearchDialog() {
        _isSearchDialogOpen.value = false
        _searchQuery.value = ""
    }

    fun openSubmitDialog() {
        _isSubmitDialogOpen.value = true
    }

    fun closeSubmitDialog() {
        _isSubmitDialogOpen.value = false
    }

    fun clearAllData() {
        repository.clearAllData()
    }

    fun saveCustomApiKey(key: String) {
        geminiService.setUserCustomApiKey(key)
        _aiErrorMessage.value = null
    }

    fun setChatTopic(topic: String) {
        _selectedChatTopic.value = topic
    }

    fun clearChat() {
        _chatMessages.value = listOf(
            ChatMessage(
                id = System.currentTimeMillis().toString(),
                role = "model",
                content = "Chat refreshed. How can I help you today with your Computer Science studies?"
            )
        )
        _aiErrorMessage.value = null
    }

    fun openAiTutorWithTopic(topic: String, prompt: String? = null) {
        _selectedChatTopic.value = topic
        _currentTab.value = ScreenTab.AI_TUTOR
        if (!prompt.isNullOrBlank()) {
            sendChatMessage(prompt)
        }
    }

    fun sendChatMessage(prompt: String) {
        if (prompt.isBlank() || _isAiThinking.value) return
        val userMsg = ChatMessage(
            id = System.currentTimeMillis().toString(),
            role = "user",
            content = prompt
        )
        _chatMessages.value = _chatMessages.value + userMsg
        _isAiThinking.value = true
        _aiErrorMessage.value = null

        viewModelScope.launch {
            val result = geminiService.sendChatMessage(
                userMessage = prompt,
                selectedTopic = _selectedChatTopic.value,
                conversationHistory = _chatMessages.value.dropLast(1)
            )
            _isAiThinking.value = false
            result.onSuccess { reply ->
                val aiMsg = ChatMessage(
                    id = (System.currentTimeMillis() + 1).toString(),
                    role = "model",
                    content = reply
                )
                _chatMessages.value = _chatMessages.value + aiMsg
            }.onFailure { err ->
                _aiErrorMessage.value = err.message ?: "Failed to get response from Gemini."
            }
        }
    }
}
