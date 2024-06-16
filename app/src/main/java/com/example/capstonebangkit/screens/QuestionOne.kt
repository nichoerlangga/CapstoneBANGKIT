package com.example.capstonebangkit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.capstonebangkit.R
import com.example.capstonebangkit.components.ImageCarousel
import com.example.capstonebangkit.data.model.Questions
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CarouselPreview() {
    val imageList = listOf(
        Questions(
            image = painterResource(R.drawable.healhub),
            title = "Gatal-gatal"
        ),
        Questions(
            image = painterResource(R.drawable.healhub),
            title = "Ruam Kulit"
        ),
        Questions(
            image = painterResource(R.drawable.healhub),
            title = "Erupsi Kulit"
        ),
        Questions(
            image = painterResource(R.drawable.healhub),
            title = "Erupsi Kulit"
        ),
        Questions(
            image = painterResource(R.drawable.healhub),
            title = "Erupsi Kulit"
        ),
        Questions(
            image = painterResource(R.drawable.healhub),
            title = "Erupsi Kulit"
        )
    )
    Surface (
        color = Color.White,
        modifier = Modifier.fillMaxSize().background(Color.White).padding(28.dp)
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        ImageCarousel(items = imageList, modifier = Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCarousel() {
    CarouselPreview()
}