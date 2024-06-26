package com.example.qrparkingpro.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.qrparkingpro.model.User
import com.example.qrparkingpro.userVM
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

    private val _isFormValidLogin = MutableStateFlow(false)
    val isFormValidLogin: StateFlow<Boolean> = _isFormValidLogin

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username

    private val _phone = MutableStateFlow("")
    val phone: StateFlow<String> = _phone

    fun onUsernameChange(newUsername: String) {
        _username.value = newUsername
        validateForm()
    }

    fun onPhoneChange(newPhone: String) {
        _phone.value = newPhone
        validateForm()
    }
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

    fun onSignup(navController: NavController, user: User) {
        userVM?.setUser(user)
        navController.navigate("home")
    }
}
