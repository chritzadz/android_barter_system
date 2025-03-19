import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.AppConstant

@Composable
fun SignupUI(viewModel: SignupViewModel = viewModel()) {
    val email by viewModel.email.collectAsState()
    val showError by viewModel.showError.collectAsState()
    val password by viewModel.password.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = email,
            onValueChange = { viewModel.onEmailChange(it) },
            label = { Text("Email") },
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = password,
            onValueChange = { viewModel.onPasswordChange(it) },
            label = { Text("Password") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { viewModel.signIn() }) {
            Text("Sign In")
        }

        if (showError != AppConstant.CREDENTIALS_VALID) {
            Text(
                text = showError,
                color = MaterialTheme.colorScheme.error,
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}
