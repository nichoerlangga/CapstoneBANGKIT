package com.example.capstonebangkit.data.model

data class QuestionsResult (
    val status: String,
    val message: String,
    val data: PredictionData
)

data class PredictionData(
    val id: String,
    val classResult: Int,
    val label: String,
    val createdAt: String
)

