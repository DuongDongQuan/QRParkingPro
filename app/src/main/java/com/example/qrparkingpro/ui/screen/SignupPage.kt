package com.example.qrparkingpro.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.qrparkingpro.R
import com.example.qrparkingpro.ui.components.InputEmail
import com.example.qrparkingpro.ui.components.InputPassword
import com.example.qrparkingpro.ui.components.InputPasswordConfirm
import com.example.qrparkingpro.viewmodel.LoginViewModel
import com.example.vehicleplate.ui.theme.LightGray40
import com.example.vehicleplate.ui.theme.SkyBlue40
import com.example.vehicleplate.ui.theme.SkyBlue60
import com.example.vehicleplate.ui.theme.SkyBlue80

@Composable
fun SignupPage(navController: NavController, loginViewModel: LoginViewModel = viewModel()) {
    val email by loginViewModel.email.collectAsState()
    val password by loginViewModel.password.collectAsState()
    val passwordConfirm by loginViewModel.passwordConfirm.collectAsState()
    val isFormValid by loginViewModel.isFormValid.collectAsState()



    Card(modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)) {
        ReturnPage(navController)
        Column(modifier = Modifier.padding(start = 30.dp, end = 30.dp).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.logo2),
                contentDescription = null,
                modifier = Modifier
                    .size(250.dp)
                    .padding(top = 60.dp),
                contentScale = ContentScale.Fit, // Hoặc ContentScale.Fit
                alignment = Alignment.Center
            )
            Text(text = "QRParkingPro",
                modifier = Modifier.padding(top = 15.dp),
                color = SkyBlue40,
                fontFamily = FontFamily(Font(R.font.inriaserif_bold, FontWeight.Normal)),
                fontSize = 28.sp
            )
            Spacer(modifier = Modifier.height(30.dp))

            InputEmail(email = email, onEmailChange = loginViewModel::onEmailChange)
            InputPasswordConfirm(password = password, passwordConfirm = passwordConfirm,
                onPasswordChange = loginViewModel::onPasswordChange, onPasswordConfirmChange = loginViewModel::onPasswordConfirmChange)
            val buttonColor = Color(0xFF1877F2)
            Button(
                onClick = { loginViewModel.onSignup(navController) },
                enabled = isFormValid,
                modifier = Modifier
                    .padding(top = 40.dp, bottom = 20.dp)
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "Register", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }

        }
    }
}
@Composable
fun ReturnPage(navController: NavController){
    val selectedColor = Color(0xFF4895EF)

    Card(
        modifier = Modifier
            .padding(top = 20.dp,start = 6.dp)
            .wrapContentSize(align = Alignment.TopStart)) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.align(Alignment.CenterVertically)            ) {
                androidx.compose.material.Icon(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "Back",
                    tint = selectedColor
                )
            }
            Text(text = "Sign Up", color = selectedColor, fontSize = 27.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignupPage() {
    SignupPage(navController = rememberNavController())
}
