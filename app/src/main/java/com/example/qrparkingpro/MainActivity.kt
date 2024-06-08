package com.example.qrparkingpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.qrparkingpro.navigation.NavGraph
import com.example.qrparkingpro.ui.theme.QRParkingProTheme
import com.example.qrparkingpro.viewmodel.HistoryListVM
import com.example.qrparkingpro.viewmodel.TopUpVM
import com.example.qrparkingpro.viewmodel.VehicleListVM

var vehicleListVM: VehicleListVM? = null
var historyListVM: HistoryListVM? = null
var topUpVM: TopUpVM? = null

class MainActivity : ComponentActivity() {
    companion object {
        var navController: NavHostController? = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vehicleListVM = VehicleListVM()
        historyListVM = HistoryListVM()
        topUpVM = TopUpVM()
        setContent {
            navController = rememberNavController()
            QRParkingProTheme {
                NavGraph(
                    navController = navController!!,
                )
            }
        }
    }
}