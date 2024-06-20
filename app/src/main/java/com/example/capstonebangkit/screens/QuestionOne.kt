package com.example.capstonebangkit.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.capstonebangkit.R
import com.example.capstonebangkit.components.ImageCarousel
import com.example.capstonebangkit.data.model.Questions
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.capstonebangkit.ui.auth.QuestionViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun QuestionOne(viewModel: QuestionViewModel = QuestionViewModel(), navController: NavHostController) {
    val imageList = listOf(
        Questions (
            image = painterResource(id = R.drawable.healhub),
            title = "Select the first symptom that you have"
        ),
        Questions (
            image = painterResource(id = R.drawable.healhub),
            title = "Select the second symptom that you have"
        ),
        Questions (
            image = painterResource(id = R.drawable.healhub),
            title = "Select the third symptom that you have"
        ),
        Questions (
            image = painterResource(id = R.drawable.healhub),
            title = "Select the fourth symptom that you have"
        ),
        Questions (
            image = painterResource(id = R.drawable.healhub),
            title = "Select the fifth symptom that you have"
        ),
        Questions (
            image = painterResource(id = R.drawable.healhub),
            title = "Select the sixth symptom that you have"
        ),
    )
    Surface (
        color = Color.White,
        modifier = Modifier.fillMaxSize().background(Color.White).padding(28.dp)
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        ImageCarousel(items = imageList, modifier = Modifier.fillMaxSize(), viewModel, navController)
    }
}

/*
@Preview(showBackground = true)
@Composable
fun PreviewCarousel(navController = ) {
    QuestionOne(navController = navController)
}*/