package com.example.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.model.DsaStatus
import com.example.model.RecentHistoryItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.json.JSONArray
import org.json.JSONObject

class LearningRepository(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("cse_compass_storage_v1", Context.MODE_PRIVATE)

    private val _bookmarks = MutableStateFlow<Set<String>>(loadBookmarks())
    val bookmarks: StateFlow<Set<String>> = _bookmarks.asStateFlow()

    private val _dsaStatusMap = MutableStateFlow<Map<String, DsaStatus>>(loadDsaStatus())
    val dsaStatusMap: StateFlow<Map<String, DsaStatus>> = _dsaStatusMap.asStateFlow()

    private val _recentHistory = MutableStateFlow<List<RecentHistoryItem>>(loadRecentHistory())
    val recentHistory: StateFlow<List<RecentHistoryItem>> = _recentHistory.asStateFlow()

    private fun loadBookmarks(): Set<String> {
        return prefs.getStringSet("KEY_BOOKMARKS", emptySet()) ?: emptySet()
    }

    private fun loadDsaStatus(): Map<String, DsaStatus> {
        val jsonStr = prefs.getString("KEY_DSA_STATUS", "{}") ?: "{}"
        val map = mutableMapOf<String, DsaStatus>()
        try {
            val json = JSONObject(jsonStr)
            val keys = json.keys()
            while (keys.hasNext()) {
                val key = keys.next()
                val statusStr = json.optString(key, DsaStatus.NOT_STARTED.name)
                map[key] = try {
                    DsaStatus.valueOf(statusStr)
                } catch (e: Exception) {
                    DsaStatus.NOT_STARTED
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return map
    }

    private fun loadRecentHistory(): List<RecentHistoryItem> {
        val jsonStr = prefs.getString("KEY_RECENT_HISTORY", "[]") ?: "[]"
        val list = mutableListOf<RecentHistoryItem>()
        try {
            val arr = JSONArray(jsonStr)
            for (i in 0 until arr.length()) {
                val obj = arr.getJSONObject(i)
                list.add(
                    RecentHistoryItem(
                        id = obj.getString("id"),
                        title = obj.getString("title"),
                        category = obj.getString("category"),
                        tabTag = obj.getString("tabTag"),
                        timestamp = obj.optLong("timestamp", System.currentTimeMillis())
                    )
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return list
    }

    fun toggleBookmark(id: String) {
        val current = _bookmarks.value.toMutableSet()
        if (current.contains(id)) {
            current.remove(id)
        } else {
            current.add(id)
        }
        _bookmarks.value = current
        prefs.edit().putStringSet("KEY_BOOKMARKS", current).apply()
    }

    fun isBookmarked(id: String): Boolean {
        return _bookmarks.value.contains(id)
    }

    fun setDsaStatus(problemId: String, status: DsaStatus) {
        val current = _dsaStatusMap.value.toMutableMap()
        current[problemId] = status
        _dsaStatusMap.value = current

        try {
            val json = JSONObject()
            current.forEach { (k, v) -> json.put(k, v.name) }
            prefs.edit().putString("KEY_DSA_STATUS", json.toString()).apply()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun recordVisit(item: RecentHistoryItem) {
        val current = _recentHistory.value.toMutableList()
        current.removeAll { it.id == item.id }
        current.add(0, item)
        val trimmed = current.take(10)
        _recentHistory.value = trimmed

        try {
            val arr = JSONArray()
            trimmed.forEach { r ->
                val obj = JSONObject()
                obj.put("id", r.id)
                obj.put("title", r.title)
                obj.put("category", r.category)
                obj.put("tabTag", r.tabTag)
                obj.put("timestamp", r.timestamp)
                arr.put(obj)
            }
            prefs.edit().putString("KEY_RECENT_HISTORY", arr.toString()).apply()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun clearAllData() {
        prefs.edit().clear().apply()
        _bookmarks.value = emptySet()
        _dsaStatusMap.value = emptyMap()
        _recentHistory.value = emptyList()
    }
}
