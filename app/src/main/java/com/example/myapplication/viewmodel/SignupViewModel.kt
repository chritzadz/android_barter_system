import androidx.lifecycle.ViewModel
import com.example.myapplication.AppConstant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.myapplication.util.CredentialValidator

class SignupViewModel : ViewModel() {
    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _showError = MutableStateFlow("")
    val showError = _showError.asStateFlow()

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun signIn() {
        if (_email.value.isEmpty()){
            _showError.value = AppConstant.EMAIL_INVALID;
        }
        else if(_password.value.isEmpty()){
            _showError.value = AppConstant.PASSWORD_INVALID;
        }
        else{
            _showError.value = "";
        }
    }
}
