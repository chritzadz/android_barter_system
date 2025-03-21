package com.example.myapplication.viewmodel

import User
import com.example.myapplication.AppConstant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.ViewModel

class SignupViewModel() : ViewModel() {
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
        }
    }
}
