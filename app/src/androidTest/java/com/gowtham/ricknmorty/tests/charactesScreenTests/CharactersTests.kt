package com.gowtham.ricknmorty.tests.charactesScreenTests

import androidx.compose.material.ExperimentalMaterialApi
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gowtham.ricknmorty.screens.CharacterDetailedScreen
import com.gowtham.ricknmorty.screens.CharactersScreen
import com.gowtham.ricknmorty.tests.BaseUiTest
import io.qameta.allure.android.runners.AllureAndroidJUnit4
import io.qameta.allure.kotlin.Allure.step
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AllureAndroidJUnit4::class)
@OptIn(ExperimentalMaterialApi::class)
class CharactersTests : BaseUiTest() {

    @Test
    fun testCharacterCard() {
        val charactersScreen = CharactersScreen(composeTestRule)
        step("Assert that an avatar of a character is present") {
            charactersScreen
                .assertAvatarPresent()
        }

        step("Assert that a name of a character is present") {
            charactersScreen
                .assertNamePresent()
        }

        step("Assert that an episode text of a character is present") {
            charactersScreen
                .assertEpisodesPresent()
        }
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


