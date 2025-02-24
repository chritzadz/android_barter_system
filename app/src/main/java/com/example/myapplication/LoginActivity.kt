package com.example.myapplication

import CredentialValidator
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myapplication.screens.LoginScreen


class LoginActivity : ComponentActivity() {
    private val validator: CredentialValidator = CredentialValidator()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
//            MyApplicationTheme {
//                LoginScreen(onLoginClick = { email, password ->
//                    handleLogin(email, password)
//                })
//            }
        }
    }

    fun handleLogin(email: String, password: String){}


//    fun moveToDashboardPage(){
//        val intent = Intent(this, DashboardActivity::class.java)
//        startActivity(intent)
//        finish() //pop from activity stack.
//    }

}