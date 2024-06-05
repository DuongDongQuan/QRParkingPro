package com.example.qrparkingpro.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.qrparkingpro.R
import com.example.qrparkingpro.ui.components.InputEmail
import com.example.qrparkingpro.ui.components.InputPassword
import com.example.vehicleplate.ui.theme.LightGray40
import com.example.vehicleplate.ui.theme.SkyBlue40
import com.example.vehicleplate.ui.theme.SkyBlue60
import com.example.vehicleplate.ui.theme.SkyBlue80

@Composable
fun LoginPage(){
    Card(modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp) ){
        Column(modifier = Modifier.padding(start = 30.dp, end = 30.dp).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Logo()
            InputContainer()
            OrText()
            ContinueWithContainer()
            SignUpContainer()
        }

    }
}

@Composable
fun Logo(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LogoPicture()
        LogoName()
    }
}

@Composable
fun LogoPicture(){
    Image(painter = painterResource(id = R.drawable.rectangle_71),
        contentDescription = "Content Description", modifier = Modifier.size(100.dp))
}

@Composable
fun LogoName(){
    Text(text = "QRParkingPro",
        modifier = Modifier.padding(top = 10.dp),
        color = SkyBlue40,
//        fontFamily = FontFamily(Font(R.font.inriaserif_bold, FontWeight.Normal)),
        fontSize = 24.sp
    )
}

@Composable
fun InputContainer(){
    InputEmail()
    InputPassword()
    SubmitButton("Sign In")
}



@Composable
fun SubmitButton(value: String){
    Button(
        onClick = {},
        shape = RectangleShape,
        modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
        colors = ButtonDefaults.buttonColors(containerColor = SkyBlue80)
    ) {
        Text(text = "$value",
//            fontFamily = FontFamily(Font(R.font.inter_regular)),
            fontWeight = FontWeight.Bold)
    }
}

@Composable
fun OrText(){
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 20.dp)){
        Box(modifier = Modifier
            .height(2.dp)
            .weight(1f)
            .background(Color.Gray)) {}
        Text(text = "OR",
            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
            color = LightGray40,
            fontWeight = FontWeight.Bold)
        Box(modifier = Modifier
            .height(2.dp)
            .weight(1f)
            .background(Color.Gray)) {}
    }
}

@Composable
fun ContinueWithContainer(){
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        ContinueText()
        MediasButton()
    }
}

@Composable
fun ContinueText(){
    Text(text = "continue with", fontSize = 15.sp, color = LightGray40)
}

@Composable
fun MediasButton(){
    Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp), horizontalArrangement = Arrangement.SpaceEvenly){
        FaceBookButton()
        GoogleButton()
    }
}

@Composable
fun FaceBookButton(){
    Button(onClick = {},
        shape = RectangleShape,
        modifier = Modifier.padding(0.dp).width(150.dp),
        colors = ButtonDefaults.buttonColors(containerColor = SkyBlue60)){
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly){
            Icon(
                painter = painterResource(R.drawable.facebook ),
                contentDescription = "Facebook logo",
                modifier = Modifier.size(23.dp))
            Text(text = "Facebook",
                modifier = Modifier.padding(start = 5.dp),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun GoogleButton(){
    Button(onClick = {},
        shape = RectangleShape,
        modifier = Modifier.padding(0.dp).width(150.dp),
        border = BorderStroke(1.dp, Color.Gray),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White)){
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly){
            Image(
                painter = painterResource(R.drawable.google),
                contentDescription = "Facebook logo",
                modifier = Modifier.size(23.dp))
            Text(text = "Google",
                modifier = Modifier.padding(start = 5.dp),
                fontSize = 15.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun SignUpContainer(){
    Column(modifier = Modifier.padding(top = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Don't have an account yet?",
            color = LightGray40
        )
        Text(text = "Sign Up",
            color = SkyBlue40,
//            fontFamily = FontFamily(Font(R.font.inter_regular)),
            fontWeight = FontWeight.SemiBold
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewLoginPage() {
    LoginPage()
}