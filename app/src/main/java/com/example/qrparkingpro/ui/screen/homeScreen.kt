package com.example.qrparkingpro.ui.screen

import androidx.compose.ui.draw.shadow
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import coil.compose.rememberAsyncImagePainter
import com.example.qrparkingpro.R
import com.example.qrparkingpro.ui.components.HomeBottomBar
import com.example.qrparkingpro.ui.theme.QRParkingProTheme
import com.example.vehicleplate.ui.theme.GreyLine

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        bottomBar = { HomeBottomBar(navController = navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .padding(top = 25.dp)
            ) {
                // Profile section
                Box(
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(18.dp))
                        .shadow(4.dp, shape = RoundedCornerShape(20.dp))
                        .padding(horizontal = 20.dp, vertical = 9.dp), // Chỉ định padding để điều chỉnh kích thước của Box
                    contentAlignment = Alignment.Center // Căn giữa nội dung bên trong Box
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .size(130.dp) // Điều chỉnh phần offset để ảnh đại diện nằm một phần bên ngoài
                                .align(Alignment.CenterHorizontally)
                                .clip(CircleShape)
                                .padding(horizontal = 9.dp, vertical = 9.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.user), // URL của ảnh đại diện
                                contentDescription = "Profile Picture",
                                modifier = Modifier.size(130.dp)
                            )
                        }
                        Text(
                            text = "BRIAN DUONG",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.CenterHorizontally) // Đảm bảo tiêu đề nằm chính giữa
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
                                modifier = Modifier.align(Alignment.CenterVertically) // Đảm bảo text nằm chính giữa
                            )
                            Spacer(modifier = Modifier.width(8.dp)) // Khoảng cách giữa hai phần tử
                            Box(
                                modifier = Modifier
                                    .background(Color.Green, RoundedCornerShape(8.dp))
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                                    .align(Alignment.CenterVertically) // Đảm bảo box nằm chính giữa
                            ) {
                                Text(text = "Verified", color = Color.White, textAlign = TextAlign.Center)
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
                        .border(width = 0.5.dp, color = Color.Gray, shape = RoundedCornerShape(18.dp))
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
                        Spacer(modifier = Modifier.width(150.dp))
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

                // Action buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(
                            onClick = { navController.navigate("register_vehicle") }, // Điều hướng tới màn hình Register Vehicle
                            modifier = Modifier
                                .size(64.dp)
                                .background(MaterialTheme.colorScheme.primary, CircleShape)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.top_up), // Thay bằng biểu tượng của bạn
                                contentDescription = "Top up/Withdraw",
                                modifier = Modifier.size(45.dp),
                                tint = Color.White
                            )
                        }
                        Text("Top up/\nWithdraw", textAlign = TextAlign.Center, color = Color(0xFF1877F2), fontWeight = FontWeight.Medium)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(
                            onClick = { navController.navigate("register_vehicle") }, // Điều hướng tới màn hình Register Vehicle
                            modifier = Modifier
                                .size(64.dp)
                                .background(MaterialTheme.colorScheme.primary, CircleShape)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.register_vehicle), // Thay bằng biểu tượng của bạn
                                contentDescription = "Register vehicle plate",
                                modifier = Modifier.size(45.dp),
                                tint = Color.White
                            )
                        }
                        Text("Register\nvehicle plate", textAlign = TextAlign.Center, color = Color(0xFF1877F2), fontWeight = FontWeight.Medium)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                // Registered license plate section
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
                        Text("Vehicle", fontWeight = FontWeight.Bold, fontSize = 19.sp)
                        Text("Vehicle No*", fontWeight = FontWeight.Bold, fontSize = 19.sp)
                    }
                    Divider(color = GreyLine, thickness = 1.dp)
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Car", fontSize = 18.sp)
                        Text("38H1 23456", fontSize = 18.sp)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Motorcycle", fontSize = 18.sp)
                        Text("51A1 99999", fontSize = 18.sp)
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
