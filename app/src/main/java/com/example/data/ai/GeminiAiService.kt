package com.example.data.ai

import android.content.Context
import android.util.Log
import com.example.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.util.concurrent.TimeUnit

data class ChatMessage(
    val id: String,
    val role: String, // "user" or "model"
    val content: String,
    val timestamp: Long = System.currentTimeMillis()
)

class GeminiAiService(private val context: Context) {
    private val client = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()

    private val userApiKeyPref = context.getSharedPreferences("cse_compass_ai_prefs", Context.MODE_PRIVATE)

    fun getUserCustomApiKey(): String {
        return userApiKeyPref.getString("CUSTOM_GEMINI_API_KEY", "") ?: ""
    }

    fun setUserCustomApiKey(key: String) {
        userApiKeyPref.edit().putString("CUSTOM_GEMINI_API_KEY", key.trim()).apply()
    }

    fun getEffectiveApiKey(): String {
        val custom = getUserCustomApiKey()
        if (custom.isNotBlank()) return custom
        return try {
            val buildKey = BuildConfig.GEMINI_API_KEY
            if (buildKey.isNotBlank() && buildKey != "MY_GEMINI_API_KEY") {
                buildKey
            } else {
                ""
            }
        } catch (e: Exception) {
            ""
        }
    }

    suspend fun sendChatMessage(
        userMessage: String,
        selectedTopic: String? = null,
        conversationHistory: List<ChatMessage> = emptyList()
    ): Result<String> = withContext(Dispatchers.IO) {
        val apiKey = getEffectiveApiKey()

        // If no custom key or BuildConfig key is configured, provide curated high-yield CSE explanation
        if (apiKey.isBlank()) {
            val offlineReply = generateLocalCseExplanation(userMessage, selectedTopic)
            return@withContext Result.success(offlineReply)
        }

        val model = "gemini-3.5-flash"
        val endpoint = "https://generativelanguage.googleapis.com/v1beta/models/$model:generateContent?key=$apiKey"

        val systemInstructionText = buildString {
            append("You are CSE Compass AI Tutor, an elite and encouraging Computer Science mentor specifically tailored for Indian engineering students (BTech CSE & AI/ML, AKTU/tier-2/tier-3 universities). ")
            append("Explain concepts with crystal clarity, high-yield exam insights, real-world analogies, code snippets (C, C++, Java, Python, or SQL), and Big-O time & space complexity. ")
            if (!selectedTopic.isNullOrBlank() && selectedTopic != "All CSE Topics") {
                append("The student is currently inquiring within the domain: '$selectedTopic'. ")
            }
            append("Format your response cleanly with markdown headers, bullet points, and code blocks. Be concise, direct, inspiring, and technically rigorous.")
        }

        try {
            val rootJson = JSONObject()

            // System instruction
            val systemPart = JSONObject().put("text", systemInstructionText)
            val systemParts = JSONArray().put(systemPart)
            val systemInstructionObj = JSONObject().put("parts", systemParts)
            rootJson.put("systemInstruction", systemInstructionObj)

            // Contents (multi-turn history) - Gemini REST API requires:
            // 1) First message must be 'user'
            // 2) Roles must alternate between 'user' and 'model'
            val contentsArray = JSONArray()

            val validTurns = mutableListOf<ChatMessage>()
            for (msg in conversationHistory.takeLast(6)) {
                if (validTurns.isEmpty() && msg.role != "user") {
                    continue // Skip leading model messages
                }
                validTurns.add(msg)
            }

            for (msg in validTurns) {
                val part = JSONObject().put("text", msg.content)
                val parts = JSONArray().put(part)
                val contentObj = JSONObject().put("role", msg.role).put("parts", parts)
                contentsArray.put(contentObj)
            }

            // Current message
            val currentPart = JSONObject().put("text", userMessage)
            val currentParts = JSONArray().put(currentPart)
            val currentContentObj = JSONObject().put("role", "user").put("parts", currentParts)
            contentsArray.put(currentContentObj)

            rootJson.put("contents", contentsArray)

            // Generation config
            val genConfig = JSONObject()
                .put("temperature", 0.7)
                .put("topP", 0.95)
                .put("topK", 40)
            rootJson.put("generationConfig", genConfig)

            val mediaType = "application/json; charset=utf-8".toMediaType()
            val requestBody = rootJson.toString().toRequestBody(mediaType)

            val request = Request.Builder()
                .url(endpoint)
                .post(requestBody)
                .build()

            val response = client.newCall(request).execute()
            val responseBody = response.body?.string() ?: ""

            if (!response.isSuccessful) {
                val errorMsg = try {
                    val errJson = JSONObject(responseBody)
                    val err = errJson.optJSONObject("error")
                    err?.optString("message") ?: "HTTP ${response.code}: $responseBody"
                } catch (e: Exception) {
                    "HTTP ${response.code}: $responseBody"
                }

                // If error is related to quota or API key, provide helpful message with fallback
                if (response.code == 400 || response.code == 403 || response.code == 429) {
                    val fallback = generateLocalCseExplanation(userMessage, selectedTopic)
                    return@withContext Result.success(
                        "$fallback\n\n*(Note: Live Gemini API returned: $errorMsg. You can tap the 🔑 key icon above to verify your key.)*"
                    )
                }

                return@withContext Result.failure(Exception(errorMsg))
            }

            val jsonResponse = JSONObject(responseBody)
            val candidates = jsonResponse.optJSONArray("candidates")
            if (candidates == null || candidates.length() == 0) {
                return@withContext Result.failure(Exception("No response generated by model."))
            }

            val firstCandidate = candidates.getJSONObject(0)
            val content = firstCandidate.getJSONObject("content")
            val parts = content.getJSONArray("parts")
            val textBuilder = StringBuilder()
            for (i in 0 until parts.length()) {
                val p = parts.getJSONObject(i)
                if (p.has("text")) {
                    textBuilder.append(p.getString("text"))
                }
            }

            val reply = textBuilder.toString()
            if (reply.isBlank()) {
                return@withContext Result.failure(Exception("Empty response received from model."))
            }

            Result.success(reply)
        } catch (e: Exception) {
            Log.e("GeminiAiService", "API call failure", e)
            val fallback = generateLocalCseExplanation(userMessage, selectedTopic)
            Result.success(
                "$fallback\n\n*(Offline Mode: Network unreachable or key pending. To connect live, verify internet & tap 🔑 to set your Gemini API key.)*"
            )
        }
    }

    /**
     * Intelligent local fallback knowledge base for Indian CSE students
     * when offline or waiting for user's Gemini key configuration.
     */
    private fun generateLocalCseExplanation(query: String, topic: String?): String {
        val q = query.lowercase()

        return when {
            q.contains("paging") || q.contains("segmentation") || q.contains("tlb") -> """
### 📖 Operating Systems: Paging vs Segmentation

**1. Paging (Fixed-Size Partitioning)**
* **Division**: Physical memory is split into fixed frames; Logical memory into equal-sized pages (typically 4 KB).
* **Fragmentation**: Immune to **External Fragmentation**, but suffers from **Internal Fragmentation** (last page may have unused bytes).
* **Hardware Support**: Page Table + TLB (Translation Lookaside Buffer).
* **Virtual Address**: `[ Page Number (p) | Offset (d) ]`

**2. Segmentation (Variable-Size User View)**
* **Division**: Memory divided based on logical modules (Code, Data, Stack, Heap, Functions).
* **Fragmentation**: Suffers from **External Fragmentation** (variable sized gaps), zero internal fragmentation.
* **Virtual Address**: `[ Segment Number (s) | Offset (d) ]` checked against Limit Register.

**3. Role of TLB (Translation Lookaside Buffer)**
* High-speed hardware cache for page table entries.
* **Effective Memory Access Time (EMAT)**:
  `EMAT = h * (t_TLB + t_RAM) + (1 - h) * (t_TLB + 2 * t_RAM)`
  *(where h is hit ratio, typically 90%+).*

💡 **AKTU Exam Tip**: Always draw the **Address Translation Architecture Diagram** showing CPU generating Logical Address -> TLB Check -> Page Table in RAM -> Physical Address in Main Memory.
            """.trimIndent()

            q.contains("3nf") || q.contains("bcnf") || q.contains("normal") -> """
### 🗄️ DBMS: 3NF vs BCNF (Boyce-Codd Normal Form)

**Fundamental Invariant**: BCNF is strictly stricter than 3NF. Every relation in BCNF is guaranteed in 3NF, but NOT vice-versa.

| Property | Third Normal Form (3NF) | Boyce-Codd Normal Form (BCNF) |
|---|---|---|
| **Condition for X -> Y** | Either X is a Super Key OR Y is a Prime Attribute | X **MUST** be a Super Key (no exception) |
| **Dependency Preservation** | **Always guaranteed** during lossless decomposition | **Not always achievable** without losing functional dependencies |
| **Anomalies Handled** | Eliminates transitive dependencies for non-prime attributes | Eliminates all anomalies caused by functional dependencies |

**Quick Verification Checklist**:
1. Find all candidate keys using attribute closure (A)+.
2. Label Prime attributes (members of any candidate key) vs Non-prime attributes.
3. For each non-trivial FD X -> Y:
   - If X is a candidate/super key => satisfies both 3NF & BCNF.
   - If X is NOT super key, but Y is prime => satisfies 3NF, but **violates BCNF**.

💡 **AKTU 10-Marker Rule**: If asked to decompose R(A, B, C, D), write the Candidate Keys clearly first, test each FD, and verify lossless join property using R1 intersection R2 -> R1 or R2.
            """.trimIndent()

            q.contains("banker") || q.contains("deadlock") -> """
### ⚙️ Banker's Algorithm (Deadlock Avoidance)

**Core Principle**: Safe State vs Unsafe State. Before granting a resource request, the OS simulates allocation to test if a safe sequence exists where every process can terminate.

**Key Matrices**:
1. `Available[m]`: Available instances of resource type R_j.
2. `Max[n][m]`: Maximum demand of process P_i.
3. `Allocation[n][m]`: Resources currently held.
4. `Need[i][j] = Max[i][j] - Allocation[i][j]`.

**Safety Check Steps**:
* Initialize `Work = Available`, `Finish[i] = false`.
* Find process P_i such that `Finish[i] == false` and `Need[i] <= Work`.
* Once found: `Work = Work + Allocation[i]`, mark `Finish[i] = true`.
* If all `Finish[i] == true`, system is in **Safe State**; order of termination is the **Safe Sequence**.
            """.trimIndent()

            q.contains("tcp") || q.contains("handshake") || q.contains("udp") -> """
### 🌐 Computer Networks: TCP 3-Way Handshake

The Transmission Control Protocol establishes a full-duplex reliable connection using SYN and ACK flags:

```
Client                               Server
  |                                    |
  | -------- SYN (seq = x) ----------> | 1. Client requests sync
  |                                    |
  | <--- SYN-ACK (seq = y, ack = x+1) -| 2. Server acknowledges & syncs
  |                                    |
  | -------- ACK (ack = y+1) --------> | 3. Client acknowledges
  |                                    |
  v       [ESTABLISHED STATE]          v
```

* **Step 1 (SYN)**: Client sends SYN with random Initial Sequence Number (ISN = x). State -> `SYN_SENT`.
* **Step 2 (SYN-ACK)**: Server allocates buffer, sends SYN with its ISN (y), and ACK for (x + 1). State -> `SYN_RCVD`.
* **Step 3 (ACK)**: Client acknowledges Server's ISN with (y + 1). Both reach `ESTABLISHED` state.

**Why Not 2-Way Handshake?**
To avoid duplicate delayed SYN packets from causing ghost connections on the server side and wasting server resources.
            """.trimIndent()

            q.contains("avl") || q.contains("tree") || q.contains("rotation") -> """
### 🌳 Data Structures: AVL Tree Self-Balancing

**Balance Factor (BF)**:
`BF = Height(Left Subtree) - Height(Right Subtree) in {-1, 0, +1}`

When an insertion causes BF not in {-1, 0, 1}, one of 4 rotations is performed:

1. **LL Rotation (Single Right)**: Insertion in left child of left subtree => Rotate Right around root.
2. **RR Rotation (Single Left)**: Insertion in right child of right subtree => Rotate Left around root.
3. **LR Rotation (Double Rotation)**: Left-Right case => Left rotation on left child, then Right rotation on root.
4. **RL Rotation (Double Rotation)**: Right-Left case => Right rotation on right child, then Left rotation on root.

**Time Complexities**:
* Search: O(log n)
* Insertion: O(log n) (at most 1 single or double rotation)
* Deletion: O(log n) (may require up to O(log n) rotations up to root)
            """.trimIndent()

            q.contains("kadane") || q.contains("subarray") -> """
### ⚡ Kadane's Algorithm: Maximum Subarray Sum

**Complexity**: Time O(n) | Space O(1)

**Intuition**: At index i, decide whether to add `nums[i]` to existing running sum, or start fresh from `nums[i]`.

```cpp
int maxSubArray(vector<int>& nums) {
    int maxSoFar = nums[0];
    int currentSum = nums[0];
    for (int i = 1; i < nums.size(); i++) {
        currentSum = max(nums[i], currentSum + nums[i]);
        maxSoFar = max(maxSoFar, currentSum);
    }
    return maxSoFar;
}
```

💡 **Edge Case**: Works flawlessly even when all numbers in the array are negative because `maxSoFar` initializes to `nums[0]` rather than 0.
            """.trimIndent()

            else -> """
### 🚀 CSE Compass AI Personalized Explanation

**Topic:** ${topic ?: "Computer Science & Engineering"}
**Query:** "$query"

**Core Concepts & Architecture:**
1. **Definition & Purpose**: In computer engineering, solving this problem requires understanding the underlying data flow, memory model, and algorithmic trade-offs.
2. **Standard Implementation**:
   * Prioritize clean separation of concerns.
   * Analyze time complexity O(n) or O(log n) versus auxiliary space constraints.
   * Watch out for edge cases: null/empty inputs, integer overflow, and boundary conditions.
3. **University Exam & Interview Tip**:
   * For university subjective questions: Always write the definition, formula/equations, neat schematic block diagram, step-by-step algorithm, and 2 real-world applications.
   * For technical interviews: Clarify input constraints first, state the brute force O(n^2) approach, then optimize to O(n) or O(n log n) before writing production-grade code.
            """.trimIndent()
        }
    }
}
