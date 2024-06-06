package com.example.qrparkingpro.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.qrparkingpro.R
import com.example.qrparkingpro.ui.components.HomeBottomBar
import com.example.qrparkingpro.ui.theme.QRParkingProTheme
import com.example.qrparkingpro.vehicleListVM
import com.example.qrparkingpro.viewmodel.VehicleListVM
import com.example.vehicleplate.ui.theme.GreyLine

@Composable
fun HomeScreen(navController: NavController) {
    val GreenText = Color(0xFF60D936)
    val scrollState = rememberScrollState()
    Scaffold(
        bottomBar = { HomeBottomBar(navController = navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .padding(top = 20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            Color.White,
                            shape = RoundedCornerShape(18.dp)
                        )
                        .border(
                            width = 0.1.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 15.dp, vertical = 11.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .size(130.dp)
                                .align(Alignment.CenterHorizontally)
                                .clip(CircleShape)
                                .padding(horizontal = 9.dp, vertical = 9.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.user),
                                contentDescription = "Profile Picture",
                                modifier = Modifier.size(130.dp)
                            )
                        }
                        Text(
                            text = "BRIAN DUONG",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Text(
                                text = "0707405997",
                                fontSize = 16.sp,
                                color = Color.Gray,
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Box(
                                modifier = Modifier
                                    .background(
                                        GreenText,
                                        RoundedCornerShape(8.dp)
                                    )
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                                    .align(Alignment.CenterVertically)
                            ) {
                                Text(
                                    text = "Verified",
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Account balance section
                Text(
                    text = "Total available account balance",
                    color = Color.Gray,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(4.dp)
                )
                Box(
                    modifier = Modifier
                        .border(
                            width = 0.5.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(18.dp)
                        )
                        .padding(horizontal = 20.dp, vertical = 5.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 0.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.hide),
                            contentDescription = "HIDE",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "100$",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        Spacer(modifier = Modifier.width(170.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.visa),
                                contentDescription = "VISA",
                                modifier = Modifier.size(40.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.paypal),
                                contentDescription = "PayPal",
                                modifier = Modifier.size(25.dp)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(
                            onClick = { navController.navigate("topup_withdraw") },

                            modifier = Modifier
                                .size(64.dp)
                                .background(
                                    MaterialTheme.colorScheme.primary,
                                    CircleShape
                                )
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.top_up),
                                contentDescription = "Top up/Withdraw",
                                modifier = Modifier.size(45.dp),
                                tint = Color.White
                            )
                        }
                        Text(
                            "Top up/\nWithdraw",
                            textAlign = TextAlign.Center,
                            color = Color(0xFF1877F2),
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(
                            onClick = { navController.navigate("register_vehicle") }, // Điều hướng tới màn hình Register Vehicle
                            modifier = Modifier
                                .size(64.dp)
                                .background(
                                    MaterialTheme.colorScheme.primary,
                                    CircleShape
                                )
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.register_vehicle), // Thay bằng biểu tượng của bạn
                                contentDescription = "Register vehicle plate",
                                modifier = Modifier.size(45.dp),
                                tint = Color.White
                            )
                        }
                        Text(
                            "Register\nvehicle plate",
                            textAlign = TextAlign.Center,
                            color = Color(0xFF1877F2),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Registered license plate",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(4.dp)
                )
                Spacer(modifier = Modifier.height(7.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, GreyLine, RoundedCornerShape(8.dp))
                        .padding(15.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Vehicle",
                            fontWeight = FontWeight.Bold,
                            fontSize = 19.sp
                        )
                        Text(
                            "Vehicle No*",
                            fontWeight = FontWeight.Bold,
                            fontSize = 19.sp
                        )
                    }
                    Divider(color = GreyLine, thickness = 1.dp)
                    Spacer(modifier = Modifier.height(6.dp))
                    vehicleListVM?.vehicles?.forEach {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(it.type.name, fontSize = 18.sp)
                            Text(it.plateNumber, fontSize = 18.sp)
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    QRParkingProTheme {
        HomeScreen(navController = rememberNavController())
    }
}
