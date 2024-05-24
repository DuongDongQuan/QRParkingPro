package com.example.qrparkingpro.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.qrparkingpro.R

@Composable
fun TopBar(navController: NavController, title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp), // Điều chỉnh chiều cao của TopBar tại đây
        contentAlignment = Alignment.Center
    ) {
        TopAppBar(
            backgroundColor = Color(0xFF1877F2),
            elevation = 0.dp,
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            },
            title = {
                    Text(
                        text = title,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp
                    )

            },
            modifier = Modifier.fillMaxSize() // Đảm bảo TopAppBar chiếm toàn bộ chiều cao của Box
        )
    }
}
