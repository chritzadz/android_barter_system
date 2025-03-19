import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.AppConstant

@Preview
@Composable
fun SignupUI(viewModel: SignupViewModel = viewModel()) {
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val firstName by viewModel.firstName.collectAsState()
    val lastName by viewModel.lastName.collectAsState()
    val showError by viewModel.showError.collectAsState()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(bottom = 10.dp)
            .padding(top = 150.dp)
    ) {
        Text(
            text = "Create an account",
            color = Color.White,
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
                .background(Color.Magenta)
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = firstName,
            onValueChange = { viewModel.onEmailChange(it) },
            label = { Text("First name") },
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = lastName,
            onValueChange = { viewModel.onEmailChange(it) },
            label = { Text("Last name") },
        )

        Spacer(modifier = Modifier.height(16.dp))

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
