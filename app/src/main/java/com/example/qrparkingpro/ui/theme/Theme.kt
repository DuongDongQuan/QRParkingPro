package com.example.qrparkingpro.ui.theme
import android.app.Activity
import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.example.vehicleplate.ui.theme.Black
import com.example.vehicleplate.ui.theme.Blue
import com.example.vehicleplate.ui.theme.GreyLine
import com.example.vehicleplate.ui.theme.GreyText
import com.example.vehicleplate.ui.theme.White

private val LightColorScheme = lightColorScheme(
    background = White,
    primary = Blue,
    secondary = Black,
    tertiary = GreyText,
    surface = GreyLine
)
@Composable
fun QRParkingProTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}