package com.example.qrparkingpro.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.qrparkingpro.model.OptionSource
import com.example.qrparkingpro.model.TopUpItem

class HistoryListVM : ViewModel() {
    var historyItems by mutableStateOf(
        listOf(
            TopUpItem(
                "Add funds to the app", "2024-06-05", "+100$", "100$",
                true, OptionSource.VISA
            ),
            TopUpItem(
                "Pay parking fee",
                "2024-06-06",
                "-2$",
                "2$",
                false,
                OptionSource.PAYPAL
            ),
            TopUpItem(
                "Withdraw to paypal", "2024-06-07", "-50$", "50$",
                false, OptionSource.PAYPAL
            ),
        )
    )

    fun addHistoryItem(historyItem: TopUpItem) {
        historyItems = historyItems + historyItem
    }

    fun removeHistoryItem(historyItem: TopUpItem) {
        historyItems = historyItems - historyItem
    }
}