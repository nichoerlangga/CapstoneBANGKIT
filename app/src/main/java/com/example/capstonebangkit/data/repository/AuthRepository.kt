package com.example.capstonebangkit.data.repository

import com.example.capstonebangkit.data.model.*
import com.example.capstonebangkit.data.remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
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
}
