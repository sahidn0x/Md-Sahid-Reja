package com.example

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import com.example.data.ai.ChatMessage
import com.example.data.ai.GeminiAiService
import com.example.ui.MainViewModel
import com.example.ui.ScreenTab
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class AiChatTest {

    @Test
    fun testInitialChatState() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val vm = MainViewModel(app)

        assertEquals(ScreenTab.HOME, vm.currentTab.value)
        assertTrue(vm.chatMessages.value.isNotEmpty())
        assertEquals("model", vm.chatMessages.value.first().role)
        assertEquals("All CSE Topics", vm.selectedChatTopic.value)
    }

    @Test
    fun testOpenAiTutorWithTopic() {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val vm = MainViewModel(app)

        vm.openAiTutorWithTopic("Operating Systems")

        assertEquals(ScreenTab.AI_TUTOR, vm.currentTab.value)
        assertEquals("Operating Systems", vm.selectedChatTopic.value)
    }

    @Test
    fun testLocalCseExplanationGeneration() = runTest {
        val app = ApplicationProvider.getApplicationContext<Application>()
        val aiService = GeminiAiService(app)

        val result = aiService.sendChatMessage(
            userMessage = "Explain Paging vs Segmentation",
            selectedTopic = "Operating Systems",
            conversationHistory = emptyList()
        )

        assertTrue(result.isSuccess)
        val explanation = result.getOrNull()
        assertNotNull(explanation)
        assertTrue(explanation!!.contains("Paging") && explanation.contains("Segmentation"))
    }
}
