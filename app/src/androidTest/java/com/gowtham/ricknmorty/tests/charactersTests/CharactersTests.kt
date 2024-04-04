package com.gowtham.ricknmorty.tests.charactersTests

import androidx.compose.material.ExperimentalMaterialApi
import com.gowtham.ricknmorty.screens.characterTab.CharacterDetailedScreen
import com.gowtham.ricknmorty.screens.characterTab.CharactersScreen
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
        val numberOfEpisodes = charactersScreen.getNumberOfEpisodes()
        step("Tap on the Rick Sanchez row") {
            charactersScreen.tapOnRickRow()
        }
        step("Check that all of Rick's episodes are present on detailed screen") {
            characterDetailedScreen.checkNumberOfShownEpisodes(numberOfEpisodes)
        }
    }

    @Test
    fun testAllInfoTagsPresentOnDetailedScreen() {
        val charactersScreen = CharactersScreen(composeTestRule)
        val characterDetailedScreen = CharacterDetailedScreen(composeTestRule)
        val listInfoTitle = listOf("Species", "Gender", "Status", "Location", "Origin")
        step("Tap on the Rick Sanchez row") {
            charactersScreen.tapOnRickRow()
        }
        step("Check if all of the tags are present of detailed screen." +
                " List of tags - $listInfoTitle") {
            characterDetailedScreen.assertAllTagsPresent(listInfoTitle)
        }
    }

    @Test
    fun testAvatarPresentsOnDetailedScreen() {
        val charactersScreen = CharactersScreen(composeTestRule)
        val characterDetailedScreen = CharacterDetailedScreen(composeTestRule)
        step("Tap on the Rick Sanchez row") {
            charactersScreen.tapOnRickRow()
        }
        step("Check that avatar presents on the detailed screen") {
            characterDetailedScreen.assertAvatarPresent()
        }
    }
}


