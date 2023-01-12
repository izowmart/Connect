package com.example.connect.presentation.splash

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.connect.presentation.MainActivity
import com.example.connect.presentation.ui.theme.ConnectTheme
import com.example.connect.presentation.util.Screen
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SplashScreenTest{
    
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @RelaxedMockK
    lateinit var navController: NavController

    @Before
    fun setUp(){
        MockKAnnotations.init(this)

    }
    
    @Test
    fun splashScreen_displaysAndDisappears() = runBlocking { 
        composeTestRule.setContent { 
            ConnectTheme {
                SplashScreen(navController = navController)
            }
        }

        composeTestRule
            .onNodeWithContentDescription("Logo")
            .assertExists()

//        verify {
//            navController.popBackStack()
//            navController.navigate(Screen.LoginScreen.route)
//        }
    }
}
