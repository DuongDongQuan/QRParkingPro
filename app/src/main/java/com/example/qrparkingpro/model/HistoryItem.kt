package com.example.qrparkingpro.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HistoryItem(
    val description: String,
    val date: String,
    val amount: String,
    val balance: String,
    val isIncome: Boolean
) : Parcelable