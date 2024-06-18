package com.example.capstonebangkit.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.capstonebangkit.R
import com.example.capstonebangkit.components.ButtonComponent
import com.example.capstonebangkit.components.CheckBoxComponent
import com.example.capstonebangkit.components.HeadingTextComponent
import com.example.capstonebangkit.components.MyTextField
import com.example.capstonebangkit.components.PasswordTextFieldComponent
import com.example.capstonebangkit.ui.auth.AuthViewModel

@Composable
fun LoginScreen(viewModel: AuthViewModel = AuthViewModel()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginResult by viewModel.signUpResult.observeAsState()
    Surface (
        color = Color.White,
        modifier = Modifier.fillMaxSize().background(Color.White).padding(28.dp)
    ) {
        Column (modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.healhub), // Replace with your image resource
                contentDescription = "Healhub Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp) // Adjust height as needed
            )
            Spacer(modifier = Modifier.height(40.dp))
            HeadingTextComponent(value = "Login to Your Account")
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(
                labelValue = "Email",
                painter = painterResource(id = R.drawable.email),
                textValue = email,
                onValueChange = { email = it }
            )
            PasswordTextFieldComponent(
                labelValue = "Password",
                painter = painterResource(id = R.drawable.password),
                passwordValue = password,
                onPasswordChange = { password = it }
            )
            CheckBoxComponent(value = "By continuing you accept our Terms of Service and Privacy Policy")
            Spacer(modifier = Modifier.height(80.dp))
            ButtonComponent(value = "Log In") {
                viewModel.login(email, password) // Add sign-up logic here
            }
            loginResult?.let {
                if (it.token.isNotEmpty()) {
                    Text("Login Successful! Token: ${it.token}")
                } else {
                    Text("Login Failed")
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfLogInScreen() {
    LoginScreen()
}