package com.example.capstonebangkit.data.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.painter.Painter

val QUESTION_OPTIONS = listOf("Yes", "No")

data class Questions(
    val image: Painter,
    val title: MutableState<MutableList<Question>>,
    val options: List<String> = QUESTION_OPTIONS
)

data class Question (
    val question: String,
    var selectedOption: MutableState<String?> = mutableStateOf(null)
)