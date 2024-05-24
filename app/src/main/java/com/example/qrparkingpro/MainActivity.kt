package com.example.qrparkingpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.qrparkingpro.navigation.NavGraph
import com.example.qrparkingpro.ui.screen.RegisterVehicleScreen
import com.example.qrparkingpro.ui.theme.QRParkingProTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QRParkingProTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}

