package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.MainViewModel
import com.example.ui.ScreenTab
import com.example.ui.components.CompassTopBar
import com.example.ui.components.GlobalSearchDialog
import com.example.ui.components.SubmitResourceDialog
import com.example.ui.screens.AboutScreen
import com.example.ui.screens.AiTutorScreen
import com.example.ui.screens.CareersScreen
import com.example.ui.screens.CoreSubjectsScreen
import com.example.ui.screens.DsaPracticeScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.MyLearningScreen
import com.example.ui.screens.PlacementScreen
import com.example.ui.screens.ProjectsScreen
import com.example.ui.screens.SpecializationsScreen
import com.example.ui.screens.UniversityScreen
import com.example.ui.theme.CSECompassTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CSECompassTheme {
                MainAppScreen(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun MainAppScreen(viewModel: MainViewModel) {
    val currentTab by viewModel.currentTab.collectAsState()
    val selectedSubjectCode by viewModel.selectedSubjectCode.collectAsState()
    val selectedCourseId by viewModel.selectedCourseId.collectAsState()
    val selectedSpecializationId by viewModel.selectedSpecializationId.collectAsState()
    val selectedProjectId by viewModel.selectedProjectId.collectAsState()
    val dsaTrack by viewModel.dsaTrack.collectAsState()

    val bookmarks by viewModel.bookmarks.collectAsState()
    val dsaStatusMap by viewModel.dsaStatusMap.collectAsState()
    val recentHistory by viewModel.recentHistory.collectAsState()

    val isSearchOpen by viewModel.isSearchDialogOpen.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val searchResults by viewModel.searchResults.collectAsState()
    val isSubmitOpen by viewModel.isSubmitDialogOpen.collectAsState()

    // Handle Android system back press
    BackHandler(enabled = currentTab != ScreenTab.HOME) {
        viewModel.navigateTo(ScreenTab.HOME, null)
    }

    val solvedCount = dsaStatusMap.values.count { it == com.example.model.DsaStatus.SOLVED }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing),
        topBar = {
            Column {
                CompassTopBar(
                    currentTab = currentTab,
                    bookmarkCount = bookmarks.size,
                    onSearchClick = { viewModel.openSearchDialog() },
                    onSubmitClick = { viewModel.openSubmitDialog() },
                    onBookmarkClick = { viewModel.navigateTo(ScreenTab.MY_LEARNING, null) },
                    onLogoClick = { viewModel.navigateTo(ScreenTab.HOME, null) }
                )

                // Scrollable Sub-Navigation Bar for all 10 sections
                ScrollableTabRow(
                    selectedTabIndex = ScreenTab.values().indexOf(currentTab),
                    edgePadding = 12.dp,
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = Color(0xFF4F46E5),
                    divider = {}
                ) {
                    ScreenTab.values().forEach { tab ->
                        val isSelected = currentTab == tab
                        Tab(
                            selected = isSelected,
                            onClick = { viewModel.navigateTo(tab, null) },
                            modifier = Modifier
                                .testTag("nav_tab_${tab.name.lowercase()}")
                                .padding(vertical = 4.dp),
                            text = {
                                Text(
                                    text = tab.title,
                                    fontSize = 11.5.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                    color = if (isSelected) Color(0xFF4F46E5) else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        )
                    }
                }
            }
        },
        bottomBar = {
            // Standard Primary M3 Navigation Bar for essential daily destinations
            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(WindowInsets.navigationBars),
                containerColor = MaterialTheme.colorScheme.surface,
                tonalElevation = 3.dp
            ) {
                val bottomDestinations = listOf(
                    ScreenTab.HOME to Icons.Default.Explore,
                    ScreenTab.AI_TUTOR to Icons.Default.AutoAwesome,
                    ScreenTab.ACADEMICS to Icons.Default.Book,
                    ScreenTab.CORE_CSE to Icons.Default.Code,
                    ScreenTab.DSA_PRACTICE to Icons.Default.CheckCircle
                )

                bottomDestinations.forEach { (tab, icon) ->
                    val isSelected = currentTab == tab
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = { viewModel.navigateTo(tab, null) },
                        icon = {
                            Icon(
                                imageVector = icon,
                                contentDescription = tab.title,
                                modifier = Modifier.size(20.dp)
                            )
                        },
                        label = {
                            Text(
                                text = tab.title,
                                fontSize = 10.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF4F46E5),
                            selectedTextColor = Color(0xFF4F46E5),
                            indicatorColor = Color(0xFFEEF2FF),
                            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            when (currentTab) {
                ScreenTab.HOME -> {
                    HomeScreen(
                        onNavigate = { tab, id -> viewModel.navigateTo(tab, id) },
                        onSearchClick = { viewModel.openSearchDialog() },
                        solvedDsaCount = solvedCount,
                        bookmarkCount = bookmarks.size
                    )
                }
                ScreenTab.AI_TUTOR -> {
                    val messages by viewModel.chatMessages.collectAsState()
                    val isThinking by viewModel.isAiThinking.collectAsState()
                    val errorMsg by viewModel.aiErrorMessage.collectAsState()
                    val selectedChatTopic by viewModel.selectedChatTopic.collectAsState()

                    AiTutorScreen(
                        messages = messages,
                        isThinking = isThinking,
                        errorMessage = errorMsg,
                        selectedTopic = selectedChatTopic,
                        onTopicSelected = { viewModel.setChatTopic(it) },
                        onSendMessage = { viewModel.sendChatMessage(it) },
                        onClearChat = { viewModel.clearChat() },
                        userApiKey = viewModel.userApiKey,
                        onSaveApiKey = { viewModel.saveCustomApiKey(it) }
                    )
                }
                ScreenTab.ACADEMICS -> {
                    UniversityScreen(
                        selectedSubjectCode = selectedSubjectCode,
                        onSelectSubject = { viewModel.selectSubject(it) },
                        isBookmarked = { viewModel.isBookmarked(it) },
                        onToggleBookmark = { viewModel.toggleBookmark(it) },
                        onAskAi = { topic, prompt -> viewModel.openAiTutorWithTopic(topic, prompt) }
                    )
                }
                ScreenTab.CORE_CSE -> {
                    CoreSubjectsScreen(
                        selectedCourseId = selectedCourseId,
                        onSelectCourse = { viewModel.selectCourse(it) },
                        onNavigate = { tab, id -> viewModel.navigateTo(tab, id) },
                        isBookmarked = { viewModel.isBookmarked(it) },
                        onToggleBookmark = { viewModel.toggleBookmark(it) }
                    )
                }
                ScreenTab.SPECIALIZATIONS -> {
                    SpecializationsScreen(
                        selectedSpecializationId = selectedSpecializationId,
                        onSelectSpecialization = { viewModel.selectSpecialization(it) },
                        isBookmarked = { viewModel.isBookmarked(it) },
                        onToggleBookmark = { viewModel.toggleBookmark(it) }
                    )
                }
                ScreenTab.DSA_PRACTICE -> {
                    DsaPracticeScreen(
                        activeTrack = dsaTrack,
                        onSelectTrack = { viewModel.setDsaTrack(it) },
                        dsaStatusMap = dsaStatusMap,
                        onSetStatus = { id, status -> viewModel.setDsaStatus(id, status) },
                        isBookmarked = { viewModel.isBookmarked(it) },
                        onToggleBookmark = { viewModel.toggleBookmark(it) }
                    )
                }
                ScreenTab.PLACEMENT -> {
                    PlacementScreen()
                }
                ScreenTab.PROJECTS -> {
                    ProjectsScreen(
                        selectedProjectId = selectedProjectId,
                        onSelectProject = { viewModel.selectProject(it) },
                        isBookmarked = { viewModel.isBookmarked(it) },
                        onToggleBookmark = { viewModel.toggleBookmark(it) }
                    )
                }
                ScreenTab.CAREERS -> {
                    CareersScreen()
                }
                ScreenTab.MY_LEARNING -> {
                    MyLearningScreen(
                        bookmarks = bookmarks,
                        dsaStatusMap = dsaStatusMap,
                        recentHistory = recentHistory,
                        onNavigate = { tab, id -> viewModel.navigateTo(tab, id) },
                        onToggleBookmark = { viewModel.toggleBookmark(it) },
                        onClearAllData = { viewModel.clearAllData() }
                    )
                }
                ScreenTab.ABOUT -> {
                    AboutScreen(
                        onSubmitResourceClick = { viewModel.openSubmitDialog() }
                    )
                }
            }
        }
    }

    // Global Search Modal
    GlobalSearchDialog(
        isOpen = isSearchOpen,
        query = searchQuery,
        results = searchResults,
        onQueryChange = { viewModel.setSearchQuery(it) },
        onResultClick = { result ->
            viewModel.navigateTo(result.targetTab, result.targetItemId)
        },
        onDismiss = { viewModel.closeSearchDialog() }
    )

    // Submit Resource Modal
    SubmitResourceDialog(
        isOpen = isSubmitOpen,
        onDismiss = { viewModel.closeSubmitDialog() }
    )
}
