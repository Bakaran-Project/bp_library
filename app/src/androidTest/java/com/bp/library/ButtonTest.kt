package com.bp.library

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.bp.library.ui.component.ButtonPrimary
import org.junit.Rule
import org.junit.Test

class ButtonTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun showButtonProperly(){
        composeRule.setContent {
            ButtonPrimary(
                text = "Click here"
            )
        }

        composeRule.onNodeWithText("Click here")
            .assertExists()
    }
}