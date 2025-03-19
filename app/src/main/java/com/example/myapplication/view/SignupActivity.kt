package com.example.myapplication.view

import SignupUI
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

public class SignupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupUI()
        }
    }
}
