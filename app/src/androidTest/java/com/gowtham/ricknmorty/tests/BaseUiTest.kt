package com.gowtham.ricknmorty.tests

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.gowtham.ricknmorty.MainActivity
import com.gowtham.ricknmorty.MainRepository
import com.gowtham.ricknmorty.MainViewModel
import com.gowtham.ricknmorty.RickNMortyApp
import com.gowtham.ricknmorty.compose.theme.TAppTheme
import com.gowtham.ricknmorty.di.AppModule
import com.gowtham.ricknmorty.remote.ApiHelperImpl
import io.qameta.allure.kotlin.Allure.step
import org.junit.Before
import org.junit.Rule

@OptIn(ExperimentalMaterialApi::class)
open class BaseUiTest {
    @ExperimentalMaterialApi
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        step("Run the app") {
            composeTestRule.setContent {
                val context = LocalContext.current
                TAppTheme {
                    RickNMortyApp(
                        null,
                        MainViewModel(
                            MainRepository(
                                ApiHelperImpl(
                                    context,
                                    AppModule.provideApolloClient(AppModule.provideHttpClient())
                                )
                            )
                        )
                    )
                }
            }
        }

    }
}