package com.example.myapplication.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.* // Use `material3` if you're using Material3
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment // Import for Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.*
import androidx.compose.ui.graphics.*
import androidx.compose.foundation.*
import androidx.compose.foundation.shape.*


@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var username by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var confirm_password by remember { mutableStateOf(TextFieldValue("")) }

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
            shape = RoundedCornerShape(15.dp),
        )

        Spacer(modifier = Modifier.height(8.dp))

        //email
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
        )

        Spacer(modifier = Modifier.height(16.dp))

        //password
        TextField(
            value = password,
            onValueChange = { password = it },
            //label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
        )

        Spacer(modifier = Modifier.height(16.dp))

        //make sure password
        TextField(
            value = confirm_password,
            onValueChange = { confirm_password= it },
            //label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { /*logic here later on*/ }) {
            Text("Sign Up")
        }
    }
}