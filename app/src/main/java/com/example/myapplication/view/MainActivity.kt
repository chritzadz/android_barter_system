package com.example.myapplication.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.content.Intent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //set splash animation logo, if needed
        //...
        //enableEdgeToEdge() //for UI

        // redirect to login
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
        finish()
    }
}