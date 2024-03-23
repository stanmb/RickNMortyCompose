package com.gowtham.ricknmorty.screens

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.junit4.ComposeContentTestRule

open class BaseScreen {
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
            onAllNodes(matcher).fetchSemanticsNodes().size == count
        }
    }
}