package com.example.qrparkingpro.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.qrparkingpro.R
import androidx.compose.foundation.layout.height


@Composable
fun HomeBottomBar(navController: NavController) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination?.route

    BottomAppBar(
        backgroundColor = Color(0xFFF1F1F1),
        elevation = 20.dp,
        modifier = Modifier.height(75.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 0.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavigationItem(
                icon = R.drawable.homemain,
                label = "Home",
                isSelected = currentDestination == "home",
                onClick = { navController.navigate("home") }
            )
            BottomNavigationItem(
                icon = R.drawable.qrcode,
                label = "QR code",
                isSelected = currentDestination == "qrcode",
                onClick = { navController.navigate("qrcode") }
            )
            BottomNavigationItem(
                icon = R.drawable.history,
                label = "History",
                isSelected = currentDestination == "history",
                onClick = { navController.navigate("history") }
            )
        }
    }
}

@Composable
fun BottomNavigationItem(
    icon: Int,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val seclectedColor = Color(0xFF1877F2)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(10.dp)
            .clickable(onClick = onClick)
    ) {
//        IconButton(
//            onClick = onClick,
//            modifier = Modifier
//                .size(80.dp)
//
//        ) {
//            Icon(
//                painter = painterResource(id = icon),
//                contentDescription = label,
//                tint = if (isSelected) seclectedColor else Color.Gray,
//                modifier = Modifier.size(if (isSelected) 130.dp else 130.dp)
//            )
//
//        }
//        Text(
//            text = label,
//            color = if (isSelected) Color(0xFF1877F2) else Color.Gray,
//            fontSize = if (isSelected) 14.sp else 12.sp,
//            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal)

        IconButton(
            onClick = onClick,
            modifier = Modifier
                .size(30.dp)

        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = label,
                tint = if (isSelected) seclectedColor else Color.Gray,
                modifier = Modifier.size(if (isSelected) 80.dp else 70.dp)
            )

        }
        Text(
            text = label,
            color = if (isSelected) Color(0xFF1877F2) else Color.Gray,
            fontSize =  17.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal)


    }
}
@Preview(showBackground = true)
@Composable
fun PreviewHomeBottomBar() {
    val navController = rememberNavController()
    HomeBottomBar(navController)
}