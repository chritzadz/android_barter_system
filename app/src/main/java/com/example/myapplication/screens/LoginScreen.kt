package com.example.myapplication.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.viewmodel.LoginViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel(), onLoginClick: (String, String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        // Email Field
        TextField(
            value = viewModel.email.value,
            onValueChange = { viewModel.email.value = it; viewModel.emailError.value = null },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            isError = viewModel.emailError.value != null
        )
        if (viewModel.emailError.value != null) {
            Text(viewModel.emailError.value!!, color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Password Field
        TextField(
            value = viewModel.password.value,
            onValueChange = { viewModel.password.value = it; viewModel.passwordError.value = null },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            isError = viewModel.passwordError.value != null
        )
        if (viewModel.passwordError.value != null) {
            Text(viewModel.passwordError.value!!, color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (viewModel.validateInputs()) {
                onLoginClick(viewModel.email.value, viewModel.password.value)
            }
        }) {
            Text("Login")
        }
    }
}
