package com.example.qrparkingpro.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

enum class OptionSource {
    PAYPAL,
    VISA
}

@Parcelize
data class TopUpItem(
    val description: String,
    val date: String,
    val amount: String,
    val balance: String,
    val isIncome: Boolean,
    val source: OptionSource
) : Parcelable