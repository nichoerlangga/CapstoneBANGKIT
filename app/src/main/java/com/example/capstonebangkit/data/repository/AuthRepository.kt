package com.example.capstonebangkit.data.repository

import android.util.Log
import com.example.capstonebangkit.data.model.*
import com.example.capstonebangkit.data.remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository {
    private val api = RetrofitInstance.api

    fun login(email: String, password: String, onResult: (AuthResponse?) -> Unit) {
        val request = LoginRequest(email, password)
        api.login(request).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                if (response.isSuccessful) {
                    onResult(response.body())
                } else {
                    onResult(null) // Handle unsuccessful response
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                onResult(null) // Handle failure
            }
        })
    }

    fun signUp(email: String, password: String, username: String, onResult: (AuthResponse?) -> Unit) {
        val request = SignUpRequest(email, password, username)
        api.signUp(request).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                if (response.isSuccessful) {
                    onResult(response.body())
                } else {
                    onResult(null) // Handle unsuccessful response
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                onResult(null) // Handle failure
            }
        })
    }

//    suspend fun inputPrediction(answersList: List<Int>, email: String): QuestionsResult {
//        val inputPrediction = inputPrediction(inputData = answersList, email = email)
//        return withContext(Dispatchers.IO) {
//            api.predict(inputPrediction)
//        }
//    }

    suspend fun inputPrediction(answersList: List<Int>, email: String): QuestionsResult? {
        val inputPrediction = inputPrediction(inputData = answersList, email = email)
        return withContext(Dispatchers.IO) {
            try {
                val response = api.predict(inputPrediction).execute()
                if (response.isSuccessful) {
                    response.body()
                } else {
                    null // Handle unsuccessful response
                }
            } catch (e: Exception) {
                e.printStackTrace()
                null // Handle failure
            }
        }
    }

    fun fetchHistory(): Flow<List<HistoryData>> = flow {
        val response: Response<HistoryResponse> = api.getPredictionHistories()
        if (response.isSuccessful) {
            response.body()?.let { historyResponse ->
                emit(historyResponse.data.map { wrapper -> wrapper.history })
            } ?: emit(emptyList())
        } else {
            emit(emptyList())
        }
    }.catch { e ->
        e.printStackTrace()
        emit(emptyList())
    }
}
