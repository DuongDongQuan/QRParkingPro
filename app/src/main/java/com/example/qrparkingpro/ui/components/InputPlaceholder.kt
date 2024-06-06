package com.example.qrparkingpro.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.qrparkingpro.R

@Composable
fun InputEmail(email: String, onEmailChange: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = onEmailChange,
        label = { Text("Email") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun InputPassword(){
    Row(verticalAlignment = Alignment.CenterVertically) {
        TextField(
            value = "",
            modifier = Modifier
                .fillMaxWidth(),
            leadingIcon = { Icon(Icons.Rounded.Lock, contentDescription = "Email Icon") },
            trailingIcon = {
                Icon(painter = painterResource(R.drawable.blind_eye),
                    contentDescription = "Blind Icon", modifier = Modifier.size(25.dp))
            },
            onValueChange = { },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = {
                InputPlaceholder("Password")
            }
        )
    }
}

@Composable
fun InputPassword(password: String, onPasswordChange: (String) -> Unit) {
    TextField(
        value = password,
        onValueChange = onPasswordChange,
        label = { Text("Password") },
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth()
    )
}
@Composable
fun InputPlaceholder(message: String){
    Text(
        text = "$message:",
        modifier = Modifier.padding(0.dp),
        color = Color.Black.copy(alpha = 0.4f)
    )
}