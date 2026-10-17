package com.example.model

enum class LanguageBadge(val label: String) {
    HINGLISH("Hinglish"),
    HINDI("Hindi"),
    ENGLISH("English")
}

enum class Difficulty(val label: String) {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced")
}

enum class DsaStatus(val label: String) {
    NOT_STARTED("Not Started"),
    ATTEMPTED("Attempted"),
    SOLVED("Solved"),
    NEEDS_REVISION("Needs Revision")
}

data class UnitTopic(
    val unitNumber: Int,
    val unitTitle: String,
    val topics: List<String>,
    val recommendedLectureUrl: String,
    val lectureLanguage: LanguageBadge,
    val notesUrl: String
)

data class UniversitySubject(
    val code: String,
    val name: String,
    val semester: Int,
    val branch: String, // "CSE", "CSE (AI/ML)", "Both"
    val academicYear: String,
    val lastVerifiedDate: String,
    val officialSyllabusUrl: String,
    val summary: String,
    val units: List<UnitTopic>,
    val examChecklist: List<String>
)

data class CoreCourse(
    val id: String,
    val name: String,
    val slug: String,
    val designatedProvider: String,
    val language: LanguageBadge,
    val playlistUrl: String,
    val prerequisites: List<String>,
    val description: String,
    val orderedTopics: List<String>,
    val miniProjects: List<String>,
    val checklist: List<String>,
    val recommendedNext: String
)

data class RoadmapPhase(
    val phase: String,
    val title: String,
    val desc: String,
    val keyTech: List<String>
)

data class CurriculumModule(
    val moduleTitle: String,
    val topics: List<String>
)

data class SpecializationResource(
    val id: String,
    val title: String,
    val provider: String,
    val accessCost: String,
    val language: LanguageBadge,
    val url: String,
    val difficulty: Difficulty,
    val description: String
)

data class SpecializationProject(
    val name: String,
    val difficulty: Difficulty,
    val description: String,
    val tech: List<String>
)

data class Specialization(
    val id: String,
    val title: String,
    val slug: String,
    val iconKey: String,
    val tagline: String,
    val prerequisites: List<String>,
    val roadmap: List<RoadmapPhase>,
    val curriculum: List<CurriculumModule>,
    val resources: List<SpecializationResource>,
    val projects: List<SpecializationProject>,
    val portfolioAdvice: List<String>,
    val careerGuidance: String
)

data class DsaProblem(
    val id: String,
    val title: String,
    val topic: String,
    val difficulty: Difficulty,
    val track: String, // "Normal" or "FAANG"
    val practiceUrl: String,
    val platform: String,
    val timeComplexity: String,
    val spaceComplexity: String,
    val prerequisites: String,
    val hint: String
)

data class PlacementMilestone(
    val semester: String,
    val focus: String,
    val actionItems: List<String>
)

data class CompanyTrack(
    val companyTier: String,
    val examples: String,
    val hiringProcess: String,
    val keyFocus: List<String>,
    val freePracticeLink: String
)

data class ProjectBlueprint(
    val id: String,
    val title: String,
    val category: String,
    val difficulty: Difficulty,
    val prerequisites: List<String>,
    val learningObjectives: List<String>,
    val steps: List<String>,
    val tools: List<String>,
    val testingChecklist: List<String>,
    val readmeOutline: List<String>,
    val extensions: List<String>
)

data class RecentHistoryItem(
    val id: String,
    val title: String,
    val category: String,
    val tabTag: String,
    val timestamp: Long = System.currentTimeMillis()
)
