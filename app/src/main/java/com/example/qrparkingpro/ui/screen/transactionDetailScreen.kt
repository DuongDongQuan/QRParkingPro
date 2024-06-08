package com.example.qrparkingpro.ui.screens

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.qrparkingpro.R
import com.example.qrparkingpro.model.OptionSource
import com.example.qrparkingpro.model.TopUpItem
import com.example.qrparkingpro.ui.components.TopBar
import com.example.qrparkingpro.ui.theme.QRParkingProTheme
import com.example.qrparkingpro.vehicleListVM

@Composable
fun TransactionDetailScreen(
    navController: NavController,
    transaction: TopUpItem
) {
    Scaffold(
        topBar = {
            TopBar(
                navController = navController,
                title = "Transaction Detail"
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            TransactionInfoCard(transaction)
            Spacer(modifier = Modifier.height(14.dp))
            TransactionDescription(transaction)
        }
    }
}

@Composable
fun TransactionInfoCard(transaction: TopUpItem) {
    val selectedColor = Color(0xFF1877F2)
    val GreenText = Color(0xFF60D936)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .padding(0.dp),
        horizontalAlignment = Alignment.Start
    ) {
        TransactionHeader(transaction, selectedColor)

        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(12.dp))
                .border(
                    width = 0.1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(9.dp),
            horizontalAlignment = Alignment.Start
        ) {
            TransactionDetailItem(
                label = "Status",
                value = "successful",
                valueColor = GreenText
            )
            TransactionDetailItem(
                label = "Created time",
                value = transaction.date,
                valueColor = selectedColor
            )
            TransactionDetailItem(
                label = "Account/Card", value = transaction
                    .source.name,
                valueColor =
                selectedColor
            )
            TransactionDetailItem(
                label = "Total fee",
                value = "Free of charge",
                valueColor = selectedColor
            )
        }
    }
}

@Composable
fun TransactionHeader(transaction: TopUpItem, selectedColor: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 22.dp)

    ) {
        Box(
            modifier = Modifier
                .size(65.dp)
                .background(color = selectedColor, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = if (transaction.isIncome) R.drawable.top_up else R.drawable.with_draw),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(37.dp)
            )
        }
        Spacer(modifier = Modifier.width(14.dp))
        Column {
            Text(
                text = transaction.description,
                color = selectedColor,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
//
            Text(
                text = transaction.amount,
                color = when {
                    transaction.amount.startsWith("+") -> Color.Green
                    transaction.amount.startsWith("-") -> Color.Red
                    else -> selectedColor
                },
                fontWeight = FontWeight.Bold,
                fontSize = 27.sp
            )
        }
    }
}

@Composable
fun TransactionDescription(transaction: TopUpItem) {
    val selectedColor = Color(0xFF1877F2)
    if (transaction.description == "Pay parking fee") {
        Text(
            text = "Description",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = selectedColor,
            modifier = Modifier.padding(10.dp)

        )
        Spacer(modifier = Modifier.height(0.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(12.dp)),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
                    .border(
                        width = 0.1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(9.dp),
                horizontalAlignment = Alignment.Start
            ) {
                TransactionDetailItem(
                    label = "License plate",
                    value = vehicleListVM?.vehicles?.firstOrNull()?.plateNumber?.take(
                        8
                    ) ?: "",
                    valueColor = selectedColor
                )
                TransactionDetailItem(
                    label = "Date",
                    value = transaction.date,
                    valueColor = selectedColor
                )
                TransactionDetailItem(
                    label = "Parked at",
                    value = "A1 parking lot",
                    valueColor = selectedColor
                )
                TransactionDetailItem(
                    label = "Parked from",
                    value = "8:00 a.m",
                    valueColor = selectedColor
                )
                TransactionDetailItem(
                    label = "Parked to",
                    value = "10:00 a.m",
                    valueColor = selectedColor
                )
                TransactionDetailItem(
                    label = "Parking fee due",
                    value = transaction.date,
                    valueColor = selectedColor
                )
            }
        }
    }
}


@Composable
fun TransactionDetailItem(
    label: String,
    value: String,
    valueColor: Color = Color.Black
) {
    val GreyText = Color(0xFF6C757D)

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            color = GreyText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            text = value,
            color = valueColor,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Preview(showBackground = true)
@Composable
fun PreviewTransactionDetailScreen() {
    val navController = rememberNavController()
    val sampleTransaction = TopUpItem(
        description = "Pay parking fee",
//         description = "Add funds to the app",
        date = "10:00 a.m - 20/3/2024",
        amount = "-1$",
//         amount = "+20$",
        balance = "80$",
        isIncome = false,
        source = OptionSource.PAYPAL
    )
    QRParkingProTheme {
        TransactionDetailScreen(
            navController = navController,
            transaction = sampleTransaction
        )
    }
}
