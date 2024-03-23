package com.gowtham.ricknmorty.screens

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performScrollToIndex
import com.gowtham.ricknmorty.utils.TestTag

class CharacterDetailedScreen(private val composeTestRule: ComposeContentTestRule): BaseScreen() {
    @OptIn(ExperimentalTestApi::class)
    fun checkNumberOfShownEpisodes(expectEpisodes: Int) {
        val lastEpisodeTestTag = "episode ${expectEpisodes - 1}"
        composeTestRule.waitUntilExists(hasTestTag(TestTag.CHARACTER_DETAILED_SCREEN_LAZY_COLUMN))
        val rowsInLazyColumn = composeTestRule.onNodeWithTag(TestTag.CHARACTER_DETAILED_SCREEN_LAZY_COLUMN).fetchSemanticsNode().config[SemanticsProperties.ContentDescription][0].toInt()
        composeTestRule.onNodeWithTag(TestTag.CHARACTER_DETAILED_SCREEN_LAZY_COLUMN).performScrollToIndex(rowsInLazyColumn - 1)
        composeTestRule.waitUntilExists(hasTestTag(lastEpisodeTestTag))
        composeTestRule.onNodeWithTag(lastEpisodeTestTag, useUnmergedTree = true).assertIsDisplayed()
    }
}