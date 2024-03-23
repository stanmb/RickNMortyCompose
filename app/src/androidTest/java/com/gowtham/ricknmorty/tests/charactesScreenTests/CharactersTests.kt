package com.gowtham.ricknmorty.tests.charactesScreenTests

import androidx.compose.material.ExperimentalMaterialApi
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gowtham.ricknmorty.screens.CharacterDetailedScreen
import com.gowtham.ricknmorty.screens.CharactersScreen
import com.gowtham.ricknmorty.tests.BaseUiTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@OptIn(ExperimentalMaterialApi::class)
class MyComposeTest : BaseUiTest() {
    @Test
    fun testCharacterCard() {
        val charactersScreen = CharactersScreen(composeTestRule)
        charactersScreen
            .assertAvatarPresent()
            .assertNamePresent()
            .assertEpisodesPresent()
    }

    @Test
    fun testAllEpisodesOfCharacterShownInDetailedCard() {
        val charactersScreen = CharactersScreen(composeTestRule)
        val characterDetailedScreen = CharacterDetailedScreen(composeTestRule)
        val episodes = charactersScreen.getNumberOfEpisodes()
        charactersScreen.tapOnRickRow()
        characterDetailedScreen.checkNumberOfShownEpisodes(episodes)

//        composeTestRule.waitUntilExists(hasTestTag("episodes"))


//        composeTestRule.onNodeWithTag("Rick Sanchez").performClick()
//        val listInfoTitle = listOf("Species", "Gender", "Status", "Location", "Origin")
//        composeTestRule.waitUntilExists(hasTestTag(listInfoTitle.first()))
//        listInfoTitle.forEach {
//            composeTestRule.onNodeWithTag(it).assertExists()
    }
}


