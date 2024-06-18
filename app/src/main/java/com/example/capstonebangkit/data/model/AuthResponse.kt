package com.example.capstonebangkit.data.model

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call

//data class LoginRequest(val email: String, val password: String)
//data class SignUpRequest(val email: String, val password: String, val name: String)
//data class AuthResponse(val token: String, val user: User)
//data class User(val id: String, val email: String, val name: String)

data class LoginRequest(val email: String, val password: String)
data class SignUpRequest(val email: String, val password: String, val username: String)
data class AuthResponse(val token: String, val user: User)
data class User(val id: String, val email: String, val name: String)


//interface AuthService {
//    @POST("/login")
//    fun login(@Body request: LoginRequest): Call<AuthResponse>
//
//    @POST("/register")
//    fun signUp(@Body request: SignUpRequest): Call<AuthResponse>
//}
