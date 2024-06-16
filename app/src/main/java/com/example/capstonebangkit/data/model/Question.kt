package com.example.capstonebangkit.data.model

import androidx.compose.ui.graphics.painter.Painter

val QUESTION_OPTIONS = listOf("Yes", "No")

data class Questions(
    val image: Painter,
    val title: String,
    val options: List<String> = QUESTION_OPTIONS
)
