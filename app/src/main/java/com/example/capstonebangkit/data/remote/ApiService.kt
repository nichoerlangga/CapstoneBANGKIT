package com.example.capstonebangkit.data.remote

import com.example.capstonebangkit.data.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("auth/login")
    fun login(@Body request: LoginRequest): Call<AuthResponse>

    @POST("auth/signup")
    fun signUp(@Body request: SignUpRequest): Call<AuthResponse>
}
