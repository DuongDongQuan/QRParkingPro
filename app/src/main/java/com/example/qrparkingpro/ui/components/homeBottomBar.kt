package com.example.qrparkingpro.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.qrparkingpro.R

@Composable
fun HomeBottomBar(navController: NavController) {
    BottomAppBar(
        backgroundColor = Color(0xFFF1F1F1), // Màu nền của BottomBar
        elevation = 20.dp, // Độ bóng của BottomBar

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavigationItem(
                icon = R.drawable.homemain,
                label = "Home",
                isSelected = false,
                onClick = { /* Navigate to Home */ }
            )
            Text(
                text = "Home"
            )
            Spacer(modifier = Modifier.width(24.dp)) // Khoảng cách giữa các mục
            BottomNavigationItem(
                icon = R.drawable.qrcode,
                label = "QR code",
                isSelected = true,
                onClick = { /* Navigate to QR code */ }
            )
            Spacer(modifier = Modifier.width(24.dp)) // Khoảng cách giữa các mục
            BottomNavigationItem(
                icon = R.drawable.history,
                label = "History",
                isSelected = false,
                onClick = { /* Navigate to History */ }
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(8.dp)
    ) {
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .size(60.dp) // Giữ nguyên kích thước của IconButton
                .background(
                    color = if (isSelected) Color(0xFF1877F2) else Color.Transparent,
                    shape = if (isSelected) CircleShape else MaterialTheme.shapes.small
                )
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = label,
                tint = if (isSelected) Color.White else Color.Gray,
                modifier = Modifier.size(if (isSelected) 60.dp else 60.dp) // Tăng kích thước của Icon
            )
        }
        Text(
            text = label,
            color = if (isSelected) Color(0xFF1877F2) else Color.Gray,
            fontSize = if (isSelected) 14.sp else 12.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}
