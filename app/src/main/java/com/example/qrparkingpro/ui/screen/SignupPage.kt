package com.example.qrparkingpro.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.qrparkingpro.R
import com.example.qrparkingpro.ui.components.InputEmail
import com.example.qrparkingpro.ui.components.InputPassword
import com.example.qrparkingpro.ui.components.InputPasswordConfirm
import com.example.vehicleplate.ui.theme.SkyBlue40


@Composable
fun SignupPage() {
    Card {
//        ReturnPage()
        SignupView()
    }

}

@Composable
fun SignupView(){
    Column(modifier = Modifier.padding(30.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {

        ImageUpload()
        InputField()
    }

}

@Composable
fun InputField(){
    Card(modifier = Modifier.padding(top = 20.dp)){
        InputEmail()
        InputPassword()
        InputPasswordConfirm()
        SubmitButton("Register")
    }

}

@Composable
fun ReturnPage(navController: NavController){
    Card(
        modifier = Modifier
            .padding(top = 20.dp,start = 10.dp)
            .wrapContentSize(align = Alignment.TopStart)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.align(Alignment.CenterVertically)            ) {
                androidx.compose.material.Icon(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
            Text(text = "Sign Up", color = SkyBlue40, fontSize = 20.sp)
        }
    }
}

@Composable
fun ImageUpload(){
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        UploadContainer()
        UploadText()
    }
}

@Composable
fun UploadContainer(){
    Box(contentAlignment = Alignment.BottomEnd){
//        Box{
//            Image(painter = painterResource(R.drawable.add_image_svgrepo_com),
//                contentDescription = "Add Image", modifier = Modifier.padding(10.dp).size(50.dp))
//        }
        Box{
            Icon(
                Icons.Default.AccountCircle,
                contentDescription = "Icon Default",
                tint = Color.Black.copy(alpha = 0.3f), modifier = Modifier.size(200.dp))
        }
    }
}

@Composable
fun UploadText(){
    Text(text = "Please upload your picture to create account",
        fontSize = 13.sp,
        color = Color.Black.copy(alpha = 0.3f),
//        fontFamily = FontFamily(Font(R.font.inter_regular)),
        fontWeight = FontWeight.SemiBold

    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSignupPage() {
    SignupPage()
}