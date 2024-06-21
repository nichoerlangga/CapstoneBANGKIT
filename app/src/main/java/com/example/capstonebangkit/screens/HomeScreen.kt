package com.example.capstonebangkit.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.capstonebangkit.R
import com.example.capstonebangkit.components.ButtonComponent
import com.example.capstonebangkit.components.HeadingTextComponent
import com.example.capstonebangkit.components.NormalTextComponent

@Composable
fun HomeScreen(navController: NavController) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                painter = painterResource(id = R.drawable.healhub),
                contentDescription = "Healhub Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(top = 30.dp)
            )
            HeadingTextComponent("Welcome to Capstone Bangkit App")

            Column {
                NormalTextComponent("Explore our features:")
                ButtonComponent("Go to Prediction") {
                    navController.navigate("QuestionOne")
                }
                Spacer(modifier = Modifier.height(12.dp))
                ButtonComponent("Go to History") {
                    navController.navigate("predictionHistory")
                }
                Spacer(modifier = Modifier.height(12.dp))
                ButtonComponent("Logout") {
                    navController.navigate("login")
                }
            }
        }
    }
}
