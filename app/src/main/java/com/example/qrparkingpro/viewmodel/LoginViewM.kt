package com.example.qrparkingpro.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : ViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _passwordConfirm = MutableStateFlow("")
    val passwordConfirm: StateFlow<String> = _passwordConfirm

    private val _isFormValid = MutableStateFlow(false)
    val isFormValid: StateFlow<Boolean> = _isFormValid

    //validateFormLogin
    private val _isFormValidLogin = MutableStateFlow(false)
    val isFormValidLogin: StateFlow<Boolean> = _isFormValidLogin
    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
        validateForm()
        validateFormLogin() //
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
        validateForm()
        validateFormLogin()
    }

    fun onPasswordConfirmChange(newPasswordConfirm: String) {
        _passwordConfirm.value = newPasswordConfirm
        validateForm()
    }

    private fun validateForm() {
        _isFormValid.value = _email.value.isNotEmpty() && _password.value.isNotEmpty() && _password.value == _passwordConfirm.value
    }

    private fun validateFormLogin() {
        _isFormValid.value = _email.value.isNotEmpty() && _password.value.isNotEmpty()
    }

    fun onLogin(navController: NavController) {
            navController.navigate("home")

    }

    fun onSignup(navController: NavController) {
        navController.navigate("login")
    }
}
