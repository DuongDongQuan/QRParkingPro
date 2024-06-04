package com.example.qrparkingpro.ui.screen

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.qrparkingpro.historyListVM
import com.example.qrparkingpro.model.HistoryItem
import com.example.qrparkingpro.ui.components.HomeBottomBar
import com.example.qrparkingpro.ui.components.TopBar
import com.google.gson.Gson

@Composable
fun HistoryScreen(navController: NavController) {
    var selectedTab by remember { mutableStateOf("All") }

    val selectedColor = Color(0xFF1877F2)
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(navController = navController, title = "History")
        TabRow(
            selectedTabIndex = when(selectedTab) {
                "All" -> 0
                "Top up" -> 1
                "Payment" -> 2
                else -> 0
            },
            backgroundColor = Color.White,
            contentColor = selectedColor,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[when(selectedTab) {
                        "All" -> 0
                        "Top up" -> 1
                        "Payment" -> 2
                        else -> 0
                    }]),
                    color = selectedColor
                )
            }
        ) {
            Tab(selected = selectedTab == "All", onClick = { selectedTab = "All" }) {
                Text("All", modifier = Modifier.padding(16.dp), fontSize = 20.sp, fontWeight = FontWeight.Bold, color = if (selectedTab == "All") selectedColor else Color.Gray)
            }
            Tab(selected = selectedTab == "Top up", onClick = { selectedTab = "Top up" }) {
                Text("Top up", modifier = Modifier.padding(16.dp), fontSize = 20.sp, fontWeight = FontWeight.Bold, color = if (selectedTab == "Top up") selectedColor else Color.Gray)
            }
            Tab(selected = selectedTab == "Payment", onClick = { selectedTab = "Payment" }) {
                Text("Payment", modifier = Modifier.padding(16.dp), fontSize = 20.sp, fontWeight = FontWeight.Bold, color = if (selectedTab == "Payment") selectedColor else Color.Gray)
            }
        }
        LazyColumn(modifier = Modifier.fillMaxSize().background(Color.White)) {
            val items = when (selectedTab) {
                "All" -> historyListVM?.historyItems
                "Top up" -> historyListVM?.historyItems?.filter { it.isIncome }
                "Payment" -> historyListVM?.historyItems?.filter { !it.isIncome }
                else -> historyListVM?.historyItems
            }
            items(items!!) { item ->
                HistoryListItem(item, navController)
            }
        }
        HomeBottomBar(navController = navController)
    }
}

@Composable
fun HistoryListItem(item: HistoryItem, navController: NavController) {
    val iconColor = Color(0xFF1877F2)
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 8.dp)
        .clickable {
            val json = Uri.encode(Gson().toJson(item))
            navController.navigate("transactionDetail/$json")
        }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(color = iconColor, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = if (item.isIncome) R.drawable.top_up2 else R.drawable.with_draw),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(25.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = item.description, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = item.date, color = Color.Gray, fontSize = 15.sp)
                Text(text = item.balance, color = Color.Gray, fontSize = 15.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = item.amount,
                color = if (item.isIncome) Color.Green else Color.Red,
                fontWeight = FontWeight.Bold,
                fontSize = 23.sp
            )
        }
        Divider()
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewHistoryScreen() {
    val navController = rememberNavController()
    HistoryScreen(navController)
}