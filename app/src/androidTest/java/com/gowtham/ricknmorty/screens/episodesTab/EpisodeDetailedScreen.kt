package com.gowtham.ricknmorty.screens.episodesTab

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import com.gowtham.ricknmorty.screens.BaseScreen
import com.gowtham.ricknmorty.utils.TestTag

class EpisodeDetailedScreen(private val composeTestRule: ComposeContentTestRule): BaseScreen(composeTestRule) {
    private fun waitForScreen() {
        composeTestRule.waitUntilExists(hasText("CHARACTERS"))
    }
    fun asserCharacterListIsNotEmpty() {
        waitForScreen()
        composeTestRule.onAllNodesWithTag(TestTag.CHARACTER_IN_EPISODE).fetchSemanticsNodes()
            .isNotEmpty()
    }

    fun assertCharactersAvatarShown() {
        waitForScreen()
        composeTestRule.onAllNodesWithTag(TestTag.CHARACTER_AVATAR).onFirst().assertIsDisplayed()
    }

    fun assertCharactersNameShown() {
        composeTestRule.onAllNodesWithTag(TestTag.CHARACTER_NAME_IN_EPISODE).onFirst().assertIsDisplayed()
    }
}