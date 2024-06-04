package com.example.qrparkingpro.ui.screen

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.qrparkingpro.R
import com.example.qrparkingpro.model.Vehicle
import com.example.qrparkingpro.model.VehicleType
import com.example.qrparkingpro.ui.components.TopBar
import com.example.qrparkingpro.ui.theme.QRParkingProTheme
import com.example.qrparkingpro.vehicleListVM
import com.example.qrparkingpro.viewmodel.VehicleListVM
import com.example.vehicleplate.ui.theme.GreyLine
import com.example.vehicleplate.ui.theme.GreyText

@Composable
fun RegisterVehicleScreen(
    navController: NavController,
) {
    var vehicleCategory by remember { mutableStateOf("Car") }
    var vehicleNumber by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    // Kiểm tra trạng thái của các trường
    val isFormValid by remember {
        derivedStateOf {
            vehicleNumber.isNotBlank() && imageUri != null
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(navController = navController, title = "Register Plate")

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                "Vehicle category:",
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 24.sp),
                modifier = Modifier.padding(top = 24.dp)
            )
            Row(Modifier.padding(vertical = 8.dp)) {
                RadioButton(
                    selected = vehicleCategory == "Car",
                    onClick = { vehicleCategory = "Car" }
                )
                Text(
                    "Car",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    fontSize = 22.sp
                )
                Spacer(modifier = Modifier.width(65.dp))
                RadioButton(
                    selected = vehicleCategory == "Motorcycle",
                    onClick = { vehicleCategory = "Motorcycle" }
                )
                Text(
                    "Motorcycle",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    fontSize = 22.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Vehicle No*:",
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 24.sp)
            )
            OutlinedTextField(
                value = vehicleNumber,
                onValueChange = { vehicleNumber = it },
                label = {
                    Text(
                        "Enter your vehicle number",
                        fontSize = 19.sp,
                        color = Color.Gray
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { /* Handle Done action */ }),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Upload vehicle picture with license plate",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 20.sp,
                        lineHeight = 30.sp,
                        color = GreyText
                    ),
                    modifier = Modifier.fillMaxWidth(0.4f)
                )
                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier
                        .size(250.dp)
                        .border(
                            width = 2.dp,
                            color = GreyLine,
                            shape = RoundedCornerShape(14.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(
                        onClick = { imagePickerLauncher.launch("image/*") },
                        modifier = Modifier.size(190.dp)
                    ) {
                        imageUri?.let {
                            Image(
                                painter = rememberAsyncImagePainter(model = it),
                                contentDescription = "Uploaded Image",
                                modifier = Modifier.fillMaxSize()
                            )
                        } ?: run {
                            Icon(
                                painter = painterResource(id = R.drawable.img),
                                contentDescription = "Upload Image",
                                modifier = Modifier.size(190.dp)
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(38.dp))
            Button(
                onClick = {
                    if (isFormValid) {
//                        navController.navigate("home")
                        navController.previousBackStackEntry?.savedStateHandle?.set(
                            "registeredVehicle",
                            "$vehicleCategory to $vehicleNumber"
                        )
                        val newVehicle = Vehicle(
                            plateNumber = vehicleNumber,
                            type = if (vehicleCategory == "Car")
                                VehicleType.CAR else
                                VehicleType.MOTORCYCLE,
                        )
                        vehicleListVM?.addVehicle(newVehicle)
                        navController.navigate("home")
                    }
                },
                enabled = isFormValid, // Nút chỉ kích hoạt khi form hợp lệ
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(
                        0xFF1877F2
                    )
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("REGISTER", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterVehicleScreenPreview() {
    QRParkingProTheme {
        RegisterVehicleScreen(
            navController = rememberNavController(),
        )
    }
}