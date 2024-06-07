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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.qrparkingpro.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun InputEmail(email: String, onEmailChange: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = onEmailChange,
        label = { Text("Email") },
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(fontSize = 18.sp)
    )
}
@Composable
fun InputPassword(
    password: String,
    onPasswordChange: (String) -> Unit,
    placeholderText: String = "Password",
    trailingIconPainter: Painter? = painterResource(R.drawable.blind_eye)
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        TextField(
            value = password,
            onValueChange = onPasswordChange,
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = { Icon(Icons.Rounded.Lock, contentDescription = "Password Icon") },
            trailingIcon = {
                if (trailingIconPainter != null) {
                    Icon(
                        painter = trailingIconPainter,
                        contentDescription = "Trailing Icon",
                        modifier = Modifier.size(25.dp)
                    )
                }
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = { Text(placeholderText) },
            textStyle = TextStyle(fontSize = 18.sp)
        )
    }
}

@Composable
fun InputUsername(username: String, onUsernameChange: (String) -> Unit) {
    TextField(
        value = username,
        onValueChange = onUsernameChange,
        label = { Text("Username") },
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(fontSize = 18.sp)
    )
}

@Composable
fun InputPhoneNumber(phone: String, onPhoneChange: (String) -> Unit) {
    TextField(
        value = phone,
        onValueChange = onPhoneChange,
        label = { Text("Phone number") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(fontSize = 18.sp)
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