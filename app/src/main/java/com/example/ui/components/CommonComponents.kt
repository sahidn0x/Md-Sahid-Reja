package com.example.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.Difficulty
import com.example.model.DsaStatus
import com.example.model.LanguageBadge

fun openExternalUrl(context: Context, url: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "Could not open link: $url", Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun LanguagePill(language: LanguageBadge, modifier: Modifier = Modifier) {
    val (bg, text) = when (language) {
        LanguageBadge.HINGLISH -> Color(0xFFFEF3C7) to Color(0xFF92400E) // Amber
        LanguageBadge.HINDI -> Color(0xFFD1FAE5) to Color(0xFF065F46) // Emerald
        LanguageBadge.ENGLISH -> Color(0xFFE0E7FF) to Color(0xFF3730A3) // Indigo
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(bg)
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Text(
            text = language.label,
            color = text,
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun DifficultyPill(difficulty: Difficulty, modifier: Modifier = Modifier) {
    val (bg, text) = when (difficulty) {
        Difficulty.BEGINNER -> Color(0xFFDCFCE7) to Color(0xFF166534)
        Difficulty.INTERMEDIATE -> Color(0xFFFEF3C7) to Color(0xFF92400E)
        Difficulty.ADVANCED -> Color(0xFFFFE4E6) to Color(0xFF9F1239)
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(bg)
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Text(
            text = difficulty.label,
            color = text,
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun DsaStatusPill(status: DsaStatus, modifier: Modifier = Modifier) {
    val (bg, text) = when (status) {
        DsaStatus.SOLVED -> Color(0xFFDCFCE7) to Color(0xFF166534)
        DsaStatus.ATTEMPTED -> Color(0xFFFEF3C7) to Color(0xFF92400E)
        DsaStatus.NEEDS_REVISION -> Color(0xFFE0E7FF) to Color(0xFF3730A3)
        DsaStatus.NOT_STARTED -> Color(0xFFF1F5F9) to Color(0xFF64748B)
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(bg)
            .padding(horizontal = 8.dp, vertical = 3.dp)
    ) {
        Text(
            text = status.label,
            color = text,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BookmarkButton(
    isBookmarked: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onToggle,
        modifier = modifier.size(36.dp)
    ) {
        Icon(
            imageVector = if (isBookmarked) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
            contentDescription = if (isBookmarked) "Remove Bookmark" else "Add Bookmark",
            tint = if (isBookmarked) Color(0xFFF59E0B) else MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(20.dp)
        )
    }
}
