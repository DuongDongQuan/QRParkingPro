package com.example.qrparkingpro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.qrparkingpro.ui.screen.HomeScreen
import com.example.qrparkingpro.ui.screen.RegisterVehicleScreen
import com.example.qrparkingpro.ui.screens.TransactionDetailScreen
import com.example.qrparkingpro.ui.screens.HistoryScreen
import com.example.qrparkingpro.model.HistoryItem
import com.google.gson.Gson

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController = navController) }
        composable("register_vehicle") { RegisterVehicleScreen(navController = navController) }
        composable("history") { HistoryScreen(navController = navController) }
        composable(
            "transactionDetail/{transaction}",
            arguments = listOf(navArgument("transaction") { type = androidx.navigation.NavType.StringType })
        ) { backStackEntry ->
            val json = backStackEntry.arguments?.getString("transaction")
            val transaction = Gson().fromJson(json, HistoryItem::class.java)
            TransactionDetailScreen(navController = navController, transaction = transaction)
        }
    }
}