package com.example.qrparkingpro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.qrparkingpro.ui.screen.HomeScreen
import com.example.qrparkingpro.ui.screen.RegisterVehicleScreen
import com.example.qrparkingpro.ui.screens.TransactionDetailScreen
import com.example.qrparkingpro.ui.screen.HistoryScreen
import com.example.qrparkingpro.model.TopUpItem
import com.example.qrparkingpro.ui.screen.LoginPage
import com.example.qrparkingpro.ui.screen.QRScreen
import com.example.qrparkingpro.ui.screen.SignupPage
import com.example.qrparkingpro.ui.screen.TopUpWithdrawPage
import com.google.gson.Gson

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginPage(navController = navController) }
        composable("signup") { SignupPage(navController = navController) }
        composable("home") {
            HomeScreen(
                navController = navController,
            )
        }
        composable("topup_withdraw") {
            TopUpWithdrawPage(option = false)
        }
        composable("register_vehicle") {
            RegisterVehicleScreen(
                navController = navController,
            )
        }
        composable("qrcode") { QRScreen(navController = navController, userId = "3003") }
        composable("history") { HistoryScreen(navController = navController) }
        composable(
            "transactionDetail/{transaction}",
            arguments = listOf(navArgument("transaction") {
                type = androidx.navigation.NavType.StringType
            })
        ) { backStackEntry ->
            val json = backStackEntry.arguments?.getString("transaction")
            val transaction = Gson().fromJson(json, TopUpItem::class.java)
            TransactionDetailScreen(
                navController = navController,
                transaction = transaction
            )
        }
    }
}