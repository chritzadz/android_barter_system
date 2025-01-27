package com.example.myapplication.screens

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.* // Use `material3` if you're using Material3
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.graphics.*
import androidx.compose.foundation.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.text.*
import com.example.myapplication.SignupActivity
import com.example.myapplication.ActivityNavigation


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navigate: ActivityNavigation) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var username by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var confirm_password by remember { mutableStateOf(TextFieldValue("")) }

    //design
    val shape = RoundedCornerShape(15.dp)
    val colors = TextFieldDefaults.textFieldColors(
        disabledTextColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Create New Account", fontSize = 24.sp)
        // email, username, password, make sure password (i guess no need to create diff interface)


        Spacer(modifier = Modifier.height(16.dp))

        //username
        TextField(
            value = username, //email or username
            onValueChange = { username = it },
            label = { Text("Username") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            shape = shape,
            colors = colors
        )

        Spacer(modifier = Modifier.height(8.dp))

        //email
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            shape = shape,
            colors = colors
        )

        Spacer(modifier = Modifier.height(16.dp))

        //password
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            shape = shape,
            colors = colors
        )

        Spacer(modifier = Modifier.height(16.dp))

        //make sure password
        TextField(
            value = confirm_password,
            onValueChange = { confirm_password= it },
            label = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            shape = shape,
            colors = colors
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { /*logic here later on*/ }){
            Text("Sign Up")
        }

        val annotatedText = buildAnnotatedString { append("Already have an account? ")
            pushStringAnnotation(tag = "link", annotation = "http://example.com")
            withStyle(style = androidx.compose.ui.text.SpanStyle(color = Color.Blue)) {
                append("Sign in")
            }
            pop()
        }

        ClickableText(
            text = annotatedText,
            onClick = {
                navigate.goToLoginActivity()
            }
        )
    }
}
