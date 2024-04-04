package com.gowtham.ricknmorty.screens.episodesTab

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.gowtham.ricknmorty.screens.BaseScreen
import com.gowtham.ricknmorty.utils.TestTag

class EpisodesScreen(private val composeTestRule: ComposeContentTestRule): BaseScreen(composeTestRule) {
    private val episodesText = composeTestRule.onNodeWithTag(TestTag.EPISODES_TAB_BAR_TEXT)
    private val episodeName = composeTestRule.onAllNodesWithTag(TestTag.EPISODE_NAME, useUnmergedTree = true).onFirst()
    private val episodeCode = composeTestRule.onAllNodesWithTag(TestTag.EPISODE_CODE, useUnmergedTree = true).onFirst()
    private val episodeDate = composeTestRule.onAllNodesWithTag(TestTag.EPISODE_DATE, useUnmergedTree = true).onFirst()


    private fun waitForEpisodes() {
        composeTestRule.waitUntilExists(hasText("Pilot"))
    }
    fun assertEpisodesScreenOpen() {
        composeTestRule.waitUntilExists(hasTestTag(TestTag.EPISODES_TAB_BAR_TEXT))
        episodesText.assertIsDisplayed()
    }

    fun assertEpisodeNameDisplayed() {
        waitForEpisodes()
        episodeName.assertIsDisplayed()
    }

    fun assertEpisodeCodeDisplayed() {
        waitForEpisodes()
        episodeCode.assertIsDisplayed()
    }

    fun assertEpisodeDateDisplayed() {
        waitForEpisodes()
        episodeDate.assertIsDisplayed()
    }

    fun tapOnFirstRow() {
        composeTestRule.waitUntilExists(hasText("Pilot"))
        composeTestRule.onAllNodesWithTag(TestTag.EPISODE_ROW).onFirst().performClick()
    }
}