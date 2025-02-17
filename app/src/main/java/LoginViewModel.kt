import android.provider.Settings.Global.getString
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.R

class LoginViewModel : ViewModel() {
    var email = mutableStateOf("")
    var password = mutableStateOf("")
    var emailError = mutableStateOf<String?>(null)
    var passwordError = mutableStateOf<String?>(null)
    private val validator = CredentialValidator()


    fun validateInputs(): Boolean {
        emailError.value = validateEmail(email.value)
        passwordError.value = validatePassword(password.value)
        return emailError.value == null && passwordError.value == null
    }

    private fun validateEmail(email: String): String? {
        return when {
            validator.isEmptyEmailAddress(email) -> "Empty email address"
            !validator.isValidEmailAddress(email)-> "Invalid email format"
            else -> null
        }
    }


    private fun validatePassword(password: String): String? {
        return when {
            validator.isEmptyPassword(password) -> "Password cannot be empty"
            else -> null
        }
    }
}