package com.example.qrparkingpro.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.qrparkingpro.model.OptionSource
import com.example.qrparkingpro.model.TopUpItem
import java.time.LocalDateTime

class TopUpVM: ViewModel() {
    var topUpData = mutableStateOf(TopUpItem("", "", "", "", false, OptionSource.VISA))

    fun setDescription(description: String) {
        topUpData.value = topUpData.value.copy(description = description)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setDate() {
        val currentDate = LocalDateTime.now()
        val ddMMyyyy = currentDate.toString().split("T")[0]
        topUpData.value = topUpData.value.copy(date = ddMMyyyy)
    }

    fun setAmount(amount: String) {
        topUpData.value = topUpData.value.copy(amount = amount)
    }

    fun setBalance(balance: String) {
        topUpData.value = topUpData.value.copy(balance = balance)
    }

    fun setIsIncome(isIncome: Boolean) {
        topUpData.value = topUpData.value.copy(isIncome = isIncome)
    }

    fun setSource(source: OptionSource) {
        topUpData.value = topUpData.value.copy(source = source)
    }

    fun resetTopUpData() {
        topUpData.value = TopUpItem("", "", "", "", false, OptionSource.VISA)
    }
}