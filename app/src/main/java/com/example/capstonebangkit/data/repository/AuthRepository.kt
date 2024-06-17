package com.example.capstonebangkit.data.repository

import com.example.capstonebangkit.data.model.*
import com.example.capstonebangkit.data.remote.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository {
    private val api = RetrofitInstance.api

    fun login(email: String, password: String, onResult: (AuthResponse?) -> Unit) {
        val request = LoginRequest(email, password)
        api.login(request).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                onResult(response.body())
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                onResult(null)
            }
        })
    }

    fun signUp(email: String, password: String, name: String, onResult: (AuthResponse?) -> Unit) {
        val request = SignUpRequest(email, password, name)
        api.signUp(request).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                onResult(response.body())
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                onResult(null)
            }
        })
    }
}
