package com.example.qrparkingpro.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.RadioButton
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.navigation.NavController

@Composable
fun TopUpWithdrawPage(option: Boolean) {
    var selectedTab by remember { mutableStateOf("Top up") }
    val selectedColor = Color(0xFF1877F2)

    Scaffold() { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .fillMaxWidth()) {
            TopBar(
                navController = rememberNavController(),
                title = "Top Up/Withdraw"
            )
            TabRow(
                selectedTabIndex = when (selectedTab) {
                    "Top up" -> 0
                    "Withdraw" -> 1
                    else -> 0
                },
                backgroundColor = Color(0xFFFFFFFF),
                contentColor = selectedColor,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier.tabIndicatorOffset(tabPositions[when (selectedTab) {
                            "Top up" -> 0
                            "Withdraw" -> 1
                            else -> 0
                        }]),
                        color = selectedColor
                    )
                }
            ) {
                Tab(selected = selectedTab == "Top up", onClick = { selectedTab = "Top up" }) {
                    Text("Top up", modifier = Modifier.padding(16.dp), fontSize = 20.sp, fontWeight = FontWeight.Bold, color = if (selectedTab == "Top up") selectedColor else Color.Gray)
                }
                Tab(selected = selectedTab == "Withdraw", onClick = { selectedTab = "Withdraw" }) {
                    Text("Withdraw", modifier = Modifier.padding(16.dp), fontSize = 20.sp, fontWeight = FontWeight.Bold, color = if (selectedTab == "Withdraw") selectedColor else Color.Gray)
                }
            }

            if (selectedTab == "Top up") {
                ContentBody(innerPadding, option = false)
            } else {
                ContentBody(innerPadding, option = true)
            }
        }
    }
}

@Composable
fun ContentBody(innerPadding: PaddingValues, option: Boolean) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MoneyDisplay(option)
        FundSource()
//        SubmitAction(option)
        SubmitAction(option, navController = rememberNavController())
    }
}

@Composable
fun MoneyDisplay(option: Boolean) {
    Column(
        modifier = Modifier
            .padding(top = 40.dp)
            .background(color = Color.White)
            .fillMaxWidth(0.85f)
            .border(0.1.dp, color = Color.Gray, shape = RoundedCornerShape(8))
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
        Text(text = textContent, fontSize = 18.sp, fontWeight = FontWeight.Bold)
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
    val amount = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(top = 10.dp)) {
        Text(text = "Amount", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        BasicTextField(
            value = amount.value,
            onValueChange = { amount.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .border(
                    width = 1.dp,
                    color = Color.Gray.copy(alpha = 0.8f),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(8.dp)
        )
    }
}


@Composable
fun FundSource() {
    var selectedOption by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth(0.85f)
            .padding(top = 30.dp)
    ) {
        FundTitle()
        Spacer(modifier = Modifier.height(25.dp))
        FundCategory("visa", isSelected = selectedOption == "visa") { selectedOption = "visa" }
        FundCategory("paypal", isSelected = selectedOption == "paypal") { selectedOption = "paypal" }
    }
}


@Composable
fun FundTitle() {
    Text(
        "Source of fund",
        modifier = Modifier.fillMaxWidth(),
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun FundCategory(item: String = "add", isSelected: Boolean = false, onSelect: () -> Unit) {
    when (item) {
        "visa" -> FundContainer("visa", isSelected, onSelect)
        "paypal" -> FundContainer("paypal", isSelected, onSelect)
        else -> FundContainer(isSelected = isSelected, onSelect = onSelect)
    }
}
@Composable
fun FundContainer(item: String = "add", isSelected: Boolean = false, onSelect: () -> Unit) {
    val heightModifier = Modifier
        .padding(vertical = 8.dp)
        .fillMaxWidth()
        .height(56.dp)
    val colored = Color(0xFF1877F2)

    Row(
        modifier = if (item == "add") heightModifier else heightModifier
            .border(
                if (isSelected) 2.dp else 1.dp,
                if (isSelected) colored else Color.Gray,
                RoundedCornerShape(8.dp)
            )
            .clickable(onClick = onSelect),
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
            val logoSize = 30.dp
            val logo = when (item) {
                "visa" -> R.drawable.logos_visa
                "paypal" -> R.drawable.logos_paypal
                else -> R.drawable.add_fund
            }
            Image(
                painter = painterResource(logo),
                contentDescription = "$item logo",
                modifier = Modifier.size(logoSize)
            )
            Column() {
                val text = when (item) {
                    "visa" -> "VISA"
                    "paypal" -> "Paypal"
                    else -> "Add Bank"
                }
                Text(
                    text = text,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                if (item != "add") {
                    Text(
                        text = "Free of charge",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
        if (item != "add") {
            RadioButton(
                selected = isSelected,
                onClick = onSelect
            )
        }
    }
}

@Composable
fun CheckButton(isSelected: Boolean = false) {
    Box(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .size(20.dp)
            .border(
                if (isSelected) 2.dp else 1.dp,
                if (isSelected) Color.Blue else Color.Black,
                shape = CircleShape
            )
    )
}

@Composable
fun SubmitAction(option: Boolean, navController: NavController) {
    val text: String
    if (option) {
        text = "WITHDRAW"
    } else {
        text = "TOP UP"
    }
    Button(
        onClick = {
            val newHistoryItem = HistoryItem(
                "Add funds to the app", "2024-07-06", "+300$",
                "300$", true
            )
            historyListVM?.addHistoryItem(newHistoryItem)
            Log.d("History List", historyListVM?.historyItems.toString())
            navController.navigate("home")
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