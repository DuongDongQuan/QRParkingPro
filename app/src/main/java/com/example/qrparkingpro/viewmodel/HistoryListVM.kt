package com.example.qrparkingpro.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.qrparkingpro.model.HistoryItem

class HistoryListVM: ViewModel() {
    var historyItems by mutableStateOf(
        listOf(
            HistoryItem("1", "2021-09-01", "100", "100", true),
            HistoryItem("2", "2021-09-02", "200", "300", false),
            HistoryItem("3", "2021-09-03", "300", "600", true),
        )
    )

    fun addHistoryItem(historyItem: HistoryItem) {
        historyItems = historyItems + historyItem
    }

    fun removeHistoryItem(historyItem: HistoryItem) {
        historyItems = historyItems - historyItem
    }
}