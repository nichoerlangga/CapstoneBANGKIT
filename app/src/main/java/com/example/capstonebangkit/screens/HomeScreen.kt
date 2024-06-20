package com.example.capstonebangkit.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.capstonebangkit.components.ButtonComponent
import com.example.capstonebangkit.components.HeadingTextComponent
import com.example.capstonebangkit.components.NormalTextComponent

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeadingTextComponent("Welcome to Capstone Bangkit App")

        NormalTextComponent("Explore our features:")

        ButtonComponent("Go to Question") {
            navController.navigate("QuestionOne")
        }

        NormalTextComponent("or")

        ButtonComponent("Go to History") {
            navController.navigate("predictionHistory")
        }

        NormalTextComponent("or")

        ButtonComponent("Logout") {
            navController.navigate("logout")
        }
    }
}
