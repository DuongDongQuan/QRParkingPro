package com.example.qrparkingpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.qrparkingpro.navigation.NavGraph
import com.example.qrparkingpro.ui.theme.QRParkingProTheme
import com.example.qrparkingpro.viewmodel.HistoryListVM
import com.example.qrparkingpro.viewmodel.VehicleListVM

var vehicleListVM: VehicleListVM? = null
var historyListVM: HistoryListVM? = null

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vehicleListVM = VehicleListVM()
        historyListVM = HistoryListVM()
        setContent {
            QRParkingProTheme {
                val navController = rememberNavController()
                NavGraph(
                    navController = navController,
                )
            }
        }
    }
}