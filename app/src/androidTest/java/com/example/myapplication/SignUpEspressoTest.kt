//package com.example.myapplication.screens
//
//import androidx.compose.ui.test.*
//import androidx.compose.ui.test.junit4.createComposeRule
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import org.junit.Rule
//import org.junit.Test
//
//class SignUpEspressoTest {
//
//    @get:Rule
//    val composeTestRule = createComposeRule()  // Setting up test environment
//
//    @Test
//    fun testSignupForm() {
//        // Set up the compose content
//        composeTestRule.setContent {
//            SignupScreen(navigate = object : ActivityNavigation {
//                override fun goToLoginActivity() {
//                    // Add your mock navigation logic here
//                }
//            })
//        }
//
//        // Fill out the username field
//        composeTestRule.onNodeWithText("Username").performTextInput("testuser")
//
//        // Fill out the email field
//        composeTestRule.onNodeWithText("Email").performTextInput("testuser@example.com")
//
//        // Fill out the password field
//        composeTestRule.onNodeWithText("Password").performTextInput("password123")
//
//        // Fill out the confirm password field
//        composeTestRule.onNodeWithText("Confirm Password").performTextInput("password123")
//
//        // Click on the Sign Up button
//        composeTestRule.onNodeWithText("Sign Up").performClick()
//
//        // You can add assertions here if you expect specific behavior after clicking Sign Up
//        // For example, check if an alert is shown or if a navigation happens.
//    }
//
//    // Optional: Preview function to see the composable in Android Studio
//    @Preview(showBackground = true)
//    @Composable
//    fun PreviewSignupScreen() {
//        SignupScreen(navigate = object : ActivityNavigation {
//            override fun goToLoginActivity() {
//                // Add mock behavior for the preview
//            }
//        })
//    }
//}
