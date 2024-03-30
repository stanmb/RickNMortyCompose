package com.gowtham.ricknmorty.screens.characterTab

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasAnyAncestor
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.text.AnnotatedString
import com.gowtham.ricknmorty.screens.BaseScreen
import com.gowtham.ricknmorty.utils.TestTag

class CharactersScreen(private val composeTestRule: ComposeContentTestRule): BaseScreen(composeTestRule) {
    private val episodesText = composeTestRule
        .onNode(hasTestTag(TestTag.EPISODES)
            .and(hasAnyAncestor(hasTestTag(TestTag.RICK_SANCHEZ)))
            ,useUnmergedTree = true
        )
    private val rickRow = composeTestRule.onNodeWithTag(TestTag.RICK_SANCHEZ)
    private val characterAvatar = composeTestRule
        .onNode(hasTestTag(TestTag.CHARACTER_AVATAR)
            .and(hasAnyAncestor(hasTestTag(TestTag.RICK_SANCHEZ)))
            ,useUnmergedTree = true
        )
    private val characterName = composeTestRule
        .onNode(hasTestTag(TestTag.CHARACTER_NAME)
            .and(hasAnyAncestor(hasTestTag(TestTag.RICK_SANCHEZ)))
            ,useUnmergedTree = true
        )

    fun assertAvatarPresent(): CharactersScreen {
        waitScreenToLoad()
        characterAvatar.assertIsDisplayed()
        return this
    }

    fun assertNamePresent(): CharactersScreen {
        waitScreenToLoad()
        characterName.assertIsDisplayed()
        return this
    }

    fun assertEpisodesPresent(): CharactersScreen {
        waitScreenToLoad()
        episodesText.assertIsDisplayed()
        return this
    }

    fun tapOnRickRow(): CharactersScreen {
        waitScreenToLoad()
        rickRow.performClick()
        return this
    }

    fun getNumberOfEpisodes(): Int {
        waitScreenToLoad()
        val episodesSemanticText = episodesText.fetchSemanticsNode().config[SemanticsProperties.Text].first().text
        return episodesSemanticText.filter { it.isDigit() }.toInt()
    }

    private fun waitScreenToLoad() {
        composeTestRule.waitUntilExists(hasTestTag(TestTag.RICK_SANCHEZ))
    }
}