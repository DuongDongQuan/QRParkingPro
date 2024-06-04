//package com.example.qrparkingpro
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.qrparkingpro.navigation.NavGraph
//import com.example.qrparkingpro.ui.screen.RegisterVehicleScreen
//import com.example.qrparkingpro.ui.theme.QRParkingProTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            QRParkingProTheme {
//                val navController = rememberNavController()
//                NavGraph(navController = navController)
//            }
//        }
//    }
//}
//
//package com.example.qrparkingpro
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Surface
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.qrparkingpro.ui.screens.HistoryScreen
//import com.example.qrparkingpro.ui.theme.QRParkingProTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            QRParkingProTheme {
//                val navController = rememberNavController()
//                Surface(color = MaterialTheme.colors.background) {
//                    NavigationComponent(navController)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun NavigationComponent(navController: NavHostController) {
//    NavHost(navController = navController, startDestination = "history") {
//        composable("history") { HistoryScreen(navController = navController) }
//        // Add other composable destinations here
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    QRParkingProTheme {
//        val navController = rememberNavController()
//        HistoryScreen(navController)
//    }
//}

package com.example.qrparkingpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.qrparkingpro.navigation.NavGraph
import com.example.qrparkingpro.ui.theme.QRParkingProTheme
import com.example.qrparkingpro.viewmodel.VehicleListVM

class MainActivity : ComponentActivity() {
    private val vehicleListVM by viewModels<VehicleListVM>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QRParkingProTheme {
                val navController = rememberNavController()
                NavGraph(
                    navController = navController,
                    vehicleListVM = vehicleListVM
                )
            }
        }
    }
}