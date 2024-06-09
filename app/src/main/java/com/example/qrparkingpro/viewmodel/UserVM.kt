package com.example.qrparkingpro.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.qrparkingpro.model.User

class UserVM: ViewModel() {
    var userData = mutableStateOf(User("", ""))

    fun setUser(user: User) {
        userData.value = user
    }
}