package com.example.qrparkingpro.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.qrparkingpro.ui.screen.HomeScreen
import com.example.qrparkingpro.ui.screen.RegisterVehicleScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController = navController) }
        composable("register_vehicle") { RegisterVehicleScreen(navController = navController) }
    }
}