package com.example.connect.presentation.components

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.text.input.KeyboardType
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.connect.presentation.MainActivity
import com.example.connect.presentation.util.TestTags.STANDARD_TEXT_FIELD
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StandardTextFieldTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

   @Test
   fun enterTooLongString_maxLengthNotExceeded(){

       composeTestRule.setContent {
           var text by remember{
               mutableStateOf("")
           }
           MaterialTheme {
               StandardTextField(
                   text = text,
                   onValueChange = {
                       text = it
                   },
                   maxLength = 5,
                   modifier = Modifier
                       .semantics {
                           testTag = STANDARD_TEXT_FIELD
                       }
               )
           }
       }
   }
    @Test
    fun enterPassword_toggleVisibility_passwordVisible(){
        composeTestRule.setContent {
            var text by remember{
                mutableStateOf("")
            }
            MaterialTheme {
                StandardTextField(
                    text = text,
                    onValueChange = {
                        text = it
                    },
                    maxLength = 5,
                    keyboardType = KeyboardType.Password
                )
            }
        }
    }
}