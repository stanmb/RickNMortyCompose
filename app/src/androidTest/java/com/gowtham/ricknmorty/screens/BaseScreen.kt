package com.gowtham.ricknmorty.screens

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.gowtham.ricknmorty.MainActivity
import org.junit.Rule

open class BaseScreen(private val composeTestRule: ComposeContentTestRule) {
    private val WAIT_UNTIL_TIMEOUT = 5_000L

    fun ComposeContentTestRule.waitUntilExists(
        matcher: SemanticsMatcher,
        timeoutMillis: Long = WAIT_UNTIL_TIMEOUT
    ) = waitUntilNodeCount(matcher, 1, timeoutMillis)

    private fun ComposeContentTestRule.waitUntilNodeCount(
        matcher: SemanticsMatcher,
        count: Int,
        timeoutMillis: Long = WAIT_UNTIL_TIMEOUT
    ) {
        waitUntil(timeoutMillis) {
            onAllNodes(matcher, useUnmergedTree = true).fetchSemanticsNodes().size == count
        }
    }

    enum class Tab {
        Characters, Episodes, Location
    }

    fun tapOnTab(tab: Tab) {
        composeTestRule.waitUntilExists(hasTestTag(tab.name))
        composeTestRule.onNodeWithTag(tab.name).performClick()
    }

    fun assertAllTagsPresent(tags: List<String>) {
        composeTestRule.waitUntilExists(hasTestTag(tags.first()))
        tags.forEach {
            composeTestRule.onNodeWithTag(it).assertExists()
        }
    }
}