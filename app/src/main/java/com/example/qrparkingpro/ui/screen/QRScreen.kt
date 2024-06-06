package com.example.qrparkingpro.ui.screen

import android.graphics.Bitmap
import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.qrparkingpro.ui.components.HomeBottomBar
import com.example.qrparkingpro.ui.components.TopBar
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.google.zxing.oned.Code128Writer
import com.google.zxing.qrcode.QRCodeWriter

@Composable
fun QRScreen(navController: NavController, userId: String) {
    val qrContent = "User ID: $userId"
    val qrBitmap = remember { generateQRCode(qrContent) }
    val barcodeBitmap = remember { generateBarcode(userId) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(androidx.compose.ui.graphics.Color.White)
    ) {
        TopBar(navController = navController, title = "QR Code")

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 0.dp, horizontal = 2.dp)
                .background(androidx.compose.ui.graphics.Color.White, shape = RoundedCornerShape(10.dp))
                .align(Alignment.CenterHorizontally),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Please display the QR code for scanning",
                color = androidx.compose.ui.graphics.Color.Gray,
                fontSize = 19.sp,
                modifier = Modifier.padding(top = 30.dp)
            )
//            // display barcode
//            barcodeBitmap?.let {
//                Image(
//                    bitmap = it.asImageBitmap(),
//                    contentDescription = "bar code",
//                    modifier = Modifier
//                        .width(320.dp)
//                        .height(90.dp)
//                        .padding(vertical = 0.dp)
//                )
//            }
            // display qr code
            qrBitmap?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = "QR code",
                    modifier = Modifier.size(450.dp)
                )
            }


        }

        Spacer(modifier = Modifier.weight(1f))
        HomeBottomBar(navController = navController)
    }
}

fun generateQRCode(content: String): Bitmap? {
    val qrCodeWriter = QRCodeWriter()
    return try {
        val bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, 200, 200)
        convertBitMatrixToBitmap(bitMatrix)
    } catch (e: WriterException) {
        e.printStackTrace()
        null
    }
}

// bar code
fun generateBarcode(content: String): Bitmap? {
    val barcodeWriter = Code128Writer()
    return try {
        val bitMatrix = barcodeWriter.encode(content, BarcodeFormat.CODE_128, 600, 150)
        convertBitMatrixToBitmap(bitMatrix)
    } catch (e: WriterException) {
        e.printStackTrace()
        null
    }
}

//  BitMatrix to Bitmap
fun convertBitMatrixToBitmap(bitMatrix: BitMatrix): Bitmap {
    val width = bitMatrix.width
    val height = bitMatrix.height
    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
    for (x in 0 until width) {
        for (y in 0 until height) {
            bitmap.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
        }
    }
    return bitmap
}

object R {
    object drawable {
        const val back = 0
        const val qrcode = 1
        const val barcode = 2
        const val homemain = 3
        const val history = 4
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewQRScreen() {
    val navController = rememberNavController()
    QRScreen(navController, userId = "sampleUserId")
}
