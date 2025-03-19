package com.example.myapplication.ui

import android.app.Activity
import com.example.myapplication.viewmodel.SignupViewModel
import android.app.Application
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.AppConstant
import com.example.myapplication.viewmodel.LoginViewModel

@Preview
@Composable
fun LoginUI(viewModel: LoginViewModel = viewModel(), activity: Activity? = null) {
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val showError by viewModel.showError.collectAsState()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(bottom = 10.dp)
            .padding(top = 100.dp)
    ) {
        Text(
            text = "Log in",
            color = Color(0xFF36454f),
            style = TextStyle(
                fontSize = 20.sp
            )

        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(5.dp)
                .clip(RoundedCornerShape(50))
                .align(Alignment.BottomCenter)
                .background(Color(0xFF36454f))
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = email,
            onValueChange = { viewModel.onEmailChange(it) },
            label = { Text("Email") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFCBC7C7),
                unfocusedContainerColor = Color(0xFFF5F5F5),
                focusedTextColor = Color(0xFF000000),
                unfocusedTextColor = Color.Gray,
                cursorColor = Color(0xFF36454f),
                focusedIndicatorColor = Color(0xFF36454f),
                unfocusedIndicatorColor = Color.Gray,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color(0xFF36454f)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = password,
            onValueChange = { viewModel.onPasswordChange(it) },
            label = { Text("Password") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFCBC7C7),
                unfocusedContainerColor = Color(0xFFF5F5F5),
                focusedTextColor = Color(0xFF000000),
                unfocusedTextColor = Color.Gray,
                cursorColor = Color(0xFF36454f),
                focusedIndicatorColor = Color(0xFF36454f),
                unfocusedIndicatorColor = Color.Gray,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color(0xFF36454f)
            )
        )

        Spacer(modifier = Modifier.height(35.dp))

        if (showError != AppConstant.CREDENTIALS_VALID) {
            Text(
                text = showError,
                color = MaterialTheme.colorScheme.error,
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.padding(top = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        Button(
            onClick = { viewModel.signIn() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF36454f),
                contentColor = Color.White
            )
        ) {
            Text("Log in")
        }

        Spacer(modifier = Modifier.height(35.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Do not have an account? ")

            ClickableText(
                text = AnnotatedString("Sign up"),
                onClick = {
                    activity?.let {
                        val intent = Intent(it, com.example.myapplication.view.SignupActivity::class.java)
                        it.startActivity(intent)
                    }
                },
                style = TextStyle(color = Color(0xFF5098A4))
            )
        }
    }
}
