package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.DsaData
import com.example.model.Difficulty
import com.example.model.DsaProblem
import com.example.model.DsaStatus
import com.example.ui.components.BookmarkButton
import com.example.ui.components.DifficultyPill
import com.example.ui.components.DsaStatusPill
import com.example.ui.components.openExternalUrl

@Composable
fun DsaPracticeScreen(
    activeTrack: String,
    onSelectTrack: (String) -> Unit,
    dsaStatusMap: Map<String, DsaStatus>,
    onSetStatus: (String, DsaStatus) -> Unit,
    isBookmarked: (String) -> Boolean,
    onToggleBookmark: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var selectedDifficulty by remember { mutableStateOf<Difficulty?>(null) }
    var expandedHintId by remember { mutableStateOf<String?>(null) }

    val trackProblems = DsaData.problems.filter { it.track == activeTrack }
    val filteredProblems = trackProblems.filter { prob ->
        selectedDifficulty == null || prob.difficulty == selectedDifficulty
    }

    val totalTrackCount = trackProblems.size
    val solvedTrackCount = trackProblems.count { dsaStatusMap[it.id] == DsaStatus.SOLVED }
    val progressFraction = if (totalTrackCount > 0) solvedTrackCount.toFloat() / totalTrackCount else 0f

    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(4.dp))
        }

        // Header info & disclaimer
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "DSA Practice: Two Distinct Tracks",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Black,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Separate foundational OA coding from advanced FAANG interview patterns. Track progress locally, check algorithmic hints, and practice directly on LeetCode.",
                        fontSize = 11.5.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = 16.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFFFEF3C7))
                            .padding(8.dp)
                    ) {
                        Text(
                            text = "Disclaimer: Completing Track B provides deep algorithmic fluency but does not guarantee employment at any specific company.",
                            fontSize = 10.sp,
                            color = Color(0xFF78350F)
                        )
                    }
                }
            }
        }

        // Dual Track Selector
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Track A Button
                val isTrackA = activeTrack == "Normal"
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(14.dp))
                        .background(if (isTrackA) Color(0xFF4F46E5) else MaterialTheme.colorScheme.surface)
                        .border(
                            1.dp,
                            if (isTrackA) Color(0xFF4338CA) else MaterialTheme.colorScheme.outline,
                            RoundedCornerShape(14.dp)
                        )
                        .clickable { onSelectTrack("Normal") }
                        .padding(12.dp)
                ) {
                    Column {
                        Text(
                            text = "Track A",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isTrackA) Color(0xFFA5B4FC) else Color(0xFF4F46E5)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Normal Practice",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isTrackA) Color.White else MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Beginner to Intermediate",
                            fontSize = 10.sp,
                            color = if (isTrackA) Color(0xFFE0E7FF) else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                // Track B Button
                val isTrackB = activeTrack == "FAANG"
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(14.dp))
                        .background(if (isTrackB) Color(0xFF7C3AED) else MaterialTheme.colorScheme.surface)
                        .border(
                            1.dp,
                            if (isTrackB) Color(0xFF6D28D9) else MaterialTheme.colorScheme.outline,
                            RoundedCornerShape(14.dp)
                        )
                        .clickable { onSelectTrack("FAANG") }
                        .padding(12.dp)
                ) {
                    Column {
                        Text(
                            text = "Track B",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isTrackB) Color(0xFFDDD6FE) else Color(0xFF7C3AED)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "FAANG-Level DSA",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isTrackB) Color.White else MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Intermediate to Advanced",
                            fontSize = 10.sp,
                            color = if (isTrackB) Color(0xFFEDE9FE) else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        // Progress Bar & Filter Bar
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "$activeTrack Track Progress",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "$solvedTrackCount of $totalTrackCount Solved",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF10B981)
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    LinearProgressIndicator(
                        progress = { progressFraction },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(7.dp)
                            .clip(RoundedCornerShape(4.dp)),
                        color = if (activeTrack == "Normal") Color(0xFF4F46E5) else Color(0xFF7C3AED),
                        trackColor = MaterialTheme.colorScheme.surfaceVariant
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // Difficulty filter chips
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        val diffs = listOf(null to "All", Difficulty.BEGINNER to "Easy", Difficulty.INTERMEDIATE to "Medium", Difficulty.ADVANCED to "Hard")
                        diffs.forEach { (diff, label) ->
                            val isSelected = selectedDifficulty == diff
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(if (isSelected) Color(0xFF0F172A) else MaterialTheme.colorScheme.surfaceVariant)
                                    .clickable { selectedDifficulty = diff }
                                    .padding(horizontal = 10.dp, vertical = 4.dp)
                            ) {
                                Text(
                                    text = label,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }
        }

        // Problems List
        items(filteredProblems) { problem ->
            val currentStatus = dsaStatusMap[problem.id] ?: DsaStatus.NOT_STARTED
            var isStatusDropdownOpen by remember { mutableStateOf(false) }
            val isHintOpen = expandedHintId == problem.id

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    // Title, difficulty & bookmark
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = problem.title,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            DifficultyPill(difficulty = problem.difficulty)
                        }

                        BookmarkButton(
                            isBookmarked = isBookmarked(problem.id),
                            onToggle = { onToggleBookmark(problem.id) }
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Topic: ${problem.topic} • Platform: ${problem.platform}",
                        fontSize = 11.5.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "Time: ${problem.timeComplexity}",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF0369A1)
                        )
                        Text(
                            text = "Space: ${problem.spaceComplexity}",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF047857)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Status Dropdown & Hint & Practice Buttons
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Status Box with dropdown
                        Box {
                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(MaterialTheme.colorScheme.surfaceVariant)
                                    .clickable { isStatusDropdownOpen = true }
                                    .padding(horizontal = 8.dp, vertical = 5.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                DsaStatusPill(status = currentStatus)
                                Spacer(modifier = Modifier.width(4.dp))
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowDown,
                                    contentDescription = "Select status",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.size(16.dp)
                                )
                            }

                            DropdownMenu(
                                expanded = isStatusDropdownOpen,
                                onDismissRequest = { isStatusDropdownOpen = false }
                            ) {
                                DsaStatus.values().forEach { status ->
                                    DropdownMenuItem(
                                        text = { Text(status.label, fontSize = 12.sp) },
                                        onClick = {
                                            onSetStatus(problem.id, status)
                                            isStatusDropdownOpen = false
                                        }
                                    )
                                }
                            }
                        }

                        // Right actions: Hint + Practice
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(MaterialTheme.colorScheme.surfaceVariant)
                                    .clickable {
                                        expandedHintId = if (isHintOpen) null else problem.id
                                    }
                                    .padding(horizontal = 10.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = if (isHintOpen) "Hide Hint" else "Hint",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color(0xFF4F46E5))
                                    .clickable { openExternalUrl(context, problem.practiceUrl) }
                                    .padding(horizontal = 10.dp, vertical = 6.dp)
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = "Practice",
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Icon(
                                        imageVector = Icons.Default.OpenInNew,
                                        contentDescription = "Open",
                                        tint = Color.White,
                                        modifier = Modifier.size(12.dp)
                                    )
                                }
                            }
                        }
                    }

                    // Expandable Hint
                    if (isHintOpen) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFFEEF2FF))
                                .padding(10.dp)
                        ) {
                            Column {
                                Text(
                                    text = "Approach / Hint:",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF312E81)
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = problem.hint,
                                    fontSize = 11.5.sp,
                                    color = Color(0xFF312E81),
                                    lineHeight = 16.sp
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Prerequisites: ${problem.prerequisites}",
                                    fontSize = 10.sp,
                                    color = Color(0xFF4338CA),
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
