package com.example.qrparkingpro.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.qrparkingpro.model.HistoryItem

class HistoryListVM: ViewModel() {
    var historyItems by mutableStateOf(
        listOf(
            HistoryItem("Add funds to the app", "2024-06-05", "+100$", "100$", true),
            HistoryItem("Pay parking fee", "2024-06-06", "-2$", "2$", false),
            HistoryItem("Withdraw to paypal", "2024-06-07", "-50$", "50$", false),
        )
    )

    fun addHistoryItem(historyItem: HistoryItem) {
        historyItems = historyItems + historyItem
    }

    fun removeHistoryItem(historyItem: HistoryItem) {
        historyItems = historyItems - historyItem
    }
}