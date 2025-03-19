import androidx.lifecycle.ViewModel
import com.example.myapplication.AppConstant
import com.example.myapplication.Repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import android.app.Application
import androidx.lifecycle.AndroidViewModel

class SignupViewModel(application: Application) : AndroidViewModel(application) {
    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _firstName = MutableStateFlow("")
    val firstName = _firstName.asStateFlow()

    private val _lastName = MutableStateFlow("")
    val lastName = _lastName.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _showError = MutableStateFlow("")
    val showError = _showError.asStateFlow()

    private val repository: UserRepository = UserRepository(application.applicationContext);

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun onFirstNameChange(firstName: String) {
        _firstName.value = firstName
    }

    fun onLastNameChange(lastName: String) {
        _lastName.value = lastName
    }


    fun signIn() {
        if (_email.value.isEmpty()){
            _showError.value = AppConstant.EMAIL_INVALID;
        }
        else if(_password.value.isEmpty()){
            _showError.value = AppConstant.PASSWORD_INVALID;
        }
        else{
            _showError.value = AppConstant.CREDENTIALS_VALID;

            val newUser = User(
                firstName = _firstName.value,
                lastName = _lastName.value,
                email = _email.value,
                password = _password.value
            )

            repository.addUser(newUser)
        }
    }
}
