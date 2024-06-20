package com.example.capstonebangkit.data.model

data class HistoryResponse(
    val status: String,
    val data: List<HistoryWrapper>
)

data class HistoryWrapper(
    val id: String,
    val history: HistoryData
)

data class HistoryData(
    val createdAt: String,
    val classResult: Int,
    val id: String,
    val label: String,
    val email: String
)
