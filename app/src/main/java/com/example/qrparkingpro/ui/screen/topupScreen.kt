package com.example.qrparkingpro.ui.screen

import android.graphics.Paint.Align
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.annotation.FractionRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.qrparkingpro.R
import com.example.qrparkingpro.historyListVM
import com.example.qrparkingpro.model.HistoryItem
import com.example.qrparkingpro.ui.components.TopBar
import com.example.qrparkingpro.ui.theme.QRParkingProTheme

@Composable
fun TopUpWithdrawPage(option: Boolean) {
    Scaffold() { innerPadding ->
        Column() {
            TopBar(
                navController = rememberNavController(),
                title = "Top Up/Withdraw"
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ButtonContainer(option, !option, 0.5f, false)
                ButtonContainer(!option, option, 1f, true)
            }
            ContentBody(innerPadding, option)
        }
    }

}

@Composable
fun ContentBody(innerPadding: PaddingValues, option: Boolean) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .wrapContentWidth(align = Alignment.CenterHorizontally),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MoneyDisplay(option)
        FundSource()
        SubmitAction(option)
    }
}

@Composable
fun MoneyDisplay(option: Boolean) {
    Column(
        modifier = Modifier
            .padding(top = 40.dp)
            .shadow(
                elevation = 20.dp,
                shape = RoundedCornerShape(15),
                spotColor = Color.Black
            )
            .background(color = Color.White)
            .fillMaxWidth(0.7f)
            .border(1.dp, color = Color.Black, shape = RoundedCornerShape(15))
            .padding(horizontal = 15.dp, vertical = 10.dp)
    ) {
        BankInfo(option)
    }
}

@Composable
fun BankInfo(option: Boolean) {
    Column() {
        val textContent: String
        if (option) {
            textContent = "Withdraw from"
        } else {
            textContent = "Top-up to"
        }
        Text(text = textContent, fontSize = 15.sp, fontWeight = FontWeight.Bold)
        Box(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth()
                    .border(
                        2.dp,
                        Color(0xFF1877F2),
                        shape = RoundedCornerShape(25)
                    )
                    .padding(top = 10.dp, bottom = 10.dp, start = 20.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(25.dp)
                )
                Column(modifier = Modifier.padding(start = 10.dp)) {
                    Text(
                        text = "QRParkingPro",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "100$",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        AmountDisplay()
    }
}

@Composable
fun AmountDisplay() {
    Column(modifier = Modifier.padding(top = 10.dp)) {
        Text(text = "Amount", fontSize = 15.sp, fontWeight = FontWeight.Bold)
        BasicTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .border(
                    width = 1.dp,
                    color = Color.Gray.copy(alpha = 0.8f),
                    shape = RoundedCornerShape(25)
                )
        )
    }
}

@Composable
fun FundSource() {
    Column(modifier = Modifier
        .fillMaxWidth(0.7f)
        .padding(top = 40.dp)) {
        FundTitle()
        FundCategory("visa")
        FundCategory("paypal")
        FundCategory()
    }
}

@Composable
fun FundTitle() {
    Text(
        "Source of fund",
        modifier = Modifier.fillMaxWidth(),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun FundCategory(item: String = "add") {
    if (item == "visa") {
        FundContainer("visa")
    } else if (item == "paypal") {
        FundContainer("paypal")
    } else {
        FundContainer()
    }
}

@Composable
fun FundContainer(item: String = "add") {
    if (item == "visa") {
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth()
                .height(50.dp)
                .border(2.dp, Color.LightGray, shape = RoundedCornerShape(20)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.logos_visa),
                    contentDescription = "visa logo",
                    modifier = Modifier.size(30.dp)
                )
                Column() {
                    Text(
                        text = "VISA",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Free of charge",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
            CheckButton()
        }
    } else if (item == "paypal") {
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth()
                .height(50.dp)
                .border(2.dp, Color.LightGray, shape = RoundedCornerShape(20)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .wrapContentSize(align = Alignment.Center)
                ) {
                    Image(
                        painter = painterResource(R.drawable.logos_paypal),
                        contentDescription = "paypal logo",
                        modifier = Modifier.size(20.dp)
                    )
                }
                Column() {
                    Text(
                        text = "Paypal",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Free of charge",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
            CheckButton()
        }
    } else {
        AddFund()
    }
}

@Composable
fun CheckButton() {
    Box(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .size(15.dp)
            .border(1.dp, color = Color.Black, shape = CircleShape)
    )
}

@Composable
fun AddFund() {
    Row(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()
            .height(50.dp)
            .border(2.dp, Color.LightGray, shape = RoundedCornerShape(20)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.add_fund),
                contentDescription = "visa logo",
                modifier = Modifier.size(30.dp)
            )
            Column() {

                Text(
                    text = "Add Bank",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

    }
}

@Composable
fun SubmitAction(option: Boolean) {
    val text: String
    if (option) {
        text = "WITHDRAW"
    } else {
        text = "TOP UP"
    }
    Button(
        onClick = {
            val newHistoryItem = HistoryItem(
                "1", "2021-09-01", "100",
                "100", true
            )
            historyListVM?.addHistoryItem(newHistoryItem)
            Log.d("History List", historyListVM?.historyItems.toString())
        },
        modifier = Modifier
            .padding(40.dp)
            .fillMaxWidth(0.6f),
        shape = RoundedCornerShape(25)
    ) {
        Text(text, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ButtonContainer(
    option: Boolean,
    active: Boolean,
    fraction: Float,
    type: Boolean
) {
    Column() {
        ButtonLayout(option, active, fraction, type)
        ButtonLine(active, fraction)
    }
}

@Composable
fun ButtonLayout(
    option: Boolean,
    active: Boolean,
    fraction: Float,
    type: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(fraction)
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .padding(vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    )
    {

        ButtonIcon(option, active)

        ButtonContent(type, active)
    }
}

@Composable
fun ButtonIcon(option: Boolean, active: Boolean) {
    val imageSize = 40.dp
    if (!option) {
        Image(
            painter = painterResource(R.drawable.top_up),
            contentDescription = "Top Up",
            modifier = Modifier
                .size(imageSize)
                .clip(RoundedCornerShape(8.dp))
                .background(color = setActiveColor(active))
        )
    } else {
        Box(
            modifier = Modifier
                .size(imageSize)
                .clip(RoundedCornerShape(8.dp))
                .background(color = setActiveColor(active)),

            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.withdraw),
                contentDescription = "Withdraw",
                modifier = Modifier
                    .size(imageSize - 8.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}

@Composable
fun ButtonContent(option: Boolean, active: Boolean) {
    val textSize = 20.sp
    val content: String
    if (option) {
        content = "Withdraw"
    } else {
        content = "Top up"
    }
    Text(text = content, fontSize = textSize)
}

@Composable
fun ButtonLine(active: Boolean, fraction: Float) {
    Box(
        modifier = Modifier
            .fillMaxWidth(fraction)
            .height(2.dp)
            .background(color = setActiveColor(active))
    )
}

@Composable
fun setActiveColor(active: Boolean): Color {
    if (active) {
        return Color(0xFF1877F2)
    } else {
        return Color(0xFFD9D9D9)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QRParkingProTheme {
        TopUpWithdrawPage(false)
    }
}