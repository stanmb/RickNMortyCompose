package com.gowtham.ricknmorty.tests.episodesTests

import androidx.compose.material.ExperimentalMaterialApi
import com.gowtham.ricknmorty.screens.BaseScreen.Tab
import com.gowtham.ricknmorty.screens.characterTab.CharacterDetailedScreen
import com.gowtham.ricknmorty.screens.characterTab.CharactersScreen
import com.gowtham.ricknmorty.screens.episodesTab.EpisodeDetailedScreen
import com.gowtham.ricknmorty.screens.episodesTab.EpisodesScreen
import com.gowtham.ricknmorty.tests.BaseUiTest
import io.qameta.allure.Allure
import io.qameta.allure.android.runners.AllureAndroidJUnit4
import io.qameta.allure.kotlin.Allure.step
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AllureAndroidJUnit4::class)
@OptIn(ExperimentalMaterialApi::class)
class EpisodesTests: BaseUiTest() {
    @Test
    fun testAllElementsOfEpisodeDisplayed() {
        val episodesScreen = EpisodesScreen(composeTestRule)
        step("Navigate to episodes screen") {
            episodesScreen.tapOnTab(Tab.Episodes)
        }
        step("Assert the name of the episode is displayed") {
            episodesScreen.assertEpisodeNameDisplayed()
        }
        step("Assert the code of the episode is displayed") {
            episodesScreen.assertEpisodeCodeDisplayed()
        }
            step("Assert the date of the episode is displayed") {
            episodesScreen.assertEpisodeDateDisplayed()
        }
    }

    @Test
    fun testAllInfoTagsPresentOnDetailedScreen() {
        val episodesScreen = EpisodesScreen(composeTestRule)
        val episodeDetailedScreen = EpisodeDetailedScreen(composeTestRule)
        val infoTitleList = listOf("Name", "Air time", "Code")
        step("Navigate to episodes screen") {
            episodesScreen.tapOnTab(Tab.Episodes)
        }
        step("Tap on the fist row of episodes list") {
            episodesScreen.tapOnFirstRow()
        }
        step("Check if all of the tags are present of detailed screen." +
                " List of tags - $infoTitleList") {
            episodeDetailedScreen.assertAllTagsPresent(infoTitleList)
        }
    }

    @Test
    fun testListOfCharactersInNotEmpty() {
        val episodesScreen = EpisodesScreen(composeTestRule)
        val episodeDetailedScreen = EpisodeDetailedScreen(composeTestRule)
        step("Navigate to episodes screen") {
            episodesScreen.tapOnTab(Tab.Episodes)
        }
        step("Tap on the fist row of episodes list") {
            episodesScreen.tapOnFirstRow()
        }
        step("Assert that list of characters is not empty") {
            episodeDetailedScreen.asserCharacterListIsNotEmpty()
        }
    }

    @Test
    fun testElementsOfCharacterShown() {
        val episodesScreen = EpisodesScreen(composeTestRule)
        val episodeDetailedScreen = EpisodeDetailedScreen(composeTestRule)
        step("Navigate to episodes screen") {
            episodesScreen.tapOnTab(Tab.Episodes)
        }
        step("Tap on the fist row of episodes list") {
            episodesScreen.tapOnFirstRow()
        }
        step("Assert that the avatar of the first character is present") {
            episodeDetailedScreen.assertCharactersAvatarShown()
        }
        step("Assert that the name of the first character is present") {
            episodeDetailedScreen.assertCharactersNameShown()
        }
    }
}