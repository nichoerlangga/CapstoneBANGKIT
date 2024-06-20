//package com.example.capstonebangkit.screens
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.livedata.observeAsState
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import com.example.capstonebangkit.R
//import com.example.capstonebangkit.components.ButtonComponent
//import com.example.capstonebangkit.components.CheckBoxComponent
//import com.example.capstonebangkit.components.HeadingTextComponent
//import com.example.capstonebangkit.components.MyTextField
//import com.example.capstonebangkit.components.PasswordTextFieldComponent
//import com.example.capstonebangkit.ui.auth.AuthViewModel
//
//@Composable
//fun SignUpScreen(viewModel: AuthViewModel = AuthViewModel(), navController: NavHostController) {
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var name by remember { mutableStateOf("") }
//    var confirmPassword by remember { mutableStateOf("") }
//    val signUpResult by viewModel.signUpResult.observeAsState()
//
//    Surface(
//        color = Color.White,
//        modifier = Modifier.fillMaxSize().background(Color.White).padding(28.dp)
//    ) {
//        Column(modifier = Modifier.fillMaxWidth()) {
//            Spacer(modifier = Modifier.height(20.dp))
//            Image(
//                painter = painterResource(id = R.drawable.healhub), // Replace with your image resource
//                contentDescription = "Healhub Logo",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp) // Adjust height as needed
//            )
//            Spacer(modifier = Modifier.height(40.dp))
//            HeadingTextComponent(value = "Create an Account")
//            Spacer(modifier = Modifier.height(20.dp))
//            MyTextField(
//                labelValue = "Full Name",
//                painter = painterResource(id = R.drawable.user),
//                textValue = name,
//                onValueChange = { name = it }
//            )
//            MyTextField(
//                labelValue = "Email",
//                painter = painterResource(id = R.drawable.email),
//                textValue = email,
//                onValueChange = { email = it }
//            )
//            PasswordTextFieldComponent(
//                labelValue = "Password",
//                painter = painterResource(id = R.drawable.password),
//                passwordValue = password,
//                onPasswordChange = { password = it }
//            )
//            PasswordTextFieldComponent(
//                labelValue = "Confirm Password",
//                painter = painterResource(id = R.drawable.password),
//                passwordValue = confirmPassword,
//                onPasswordChange = { confirmPassword = it }
//            )
//            CheckBoxComponent(value = "By continuing you accept our Terms of Service and Privacy Policy")
//            Spacer(modifier = Modifier.height(80.dp))
//            ButtonComponent(value = "Sign Up") {
//                viewModel.signUp(email, password, name) // Add sign-up logic here
//            }
//            signUpResult?.let {
//                if (it.token.isNotEmpty()) {
//                    Text("Sign Up Successful! Token: ${it.token}")
//                    navController.navigate("QuestionOne")
//                } else {
//                    Text("Sign Up Failed")
//                }
//            }
//        }
//    }
//}
//
//
//@Preview
//@Composable
//fun DefaultPreviewOfSignUpScreen() {
//    // SignUpScreen()
//}

package com.example.capstonebangkit.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.capstonebangkit.R
import com.example.capstonebangkit.components.*
import com.example.capstonebangkit.ui.auth.AuthViewModel
@Composable
fun SignUpScreen(viewModel: AuthViewModel = androidx.lifecycle.viewmodel.compose.viewModel(), navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val signUpResult by viewModel.signUpResult.observeAsState()

    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.healhub),
                contentDescription = "Healhub Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            HeadingTextComponent(value = "Create an Account")
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(
                labelValue = "Username",
                painter = painterResource(id = R.drawable.user),
                textValue = username,
                onValueChange = { username = it }
            )
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
            PasswordTextFieldComponent(
                labelValue = "Confirm Password",
                painter = painterResource(id = R.drawable.password),
                passwordValue = confirmPassword,
                onPasswordChange = { confirmPassword = it }
            )
            CheckBoxComponent(value = "By continuing you accept our Terms of Service and Privacy Policy")
            Spacer(modifier = Modifier.height(80.dp))
            ButtonComponent(value = "Sign Up") {
                viewModel.signUp(email, password, username)
            }
            signUpResult?.let { result ->
//                if (result.token.isNotEmpty()) {
                    Text("Sign Up Successful! Token: ${result.token}")
                    LaunchedEffect(Unit){navController.navigate("homescreen")}
//                } else {
//                    Text("Sign Up Failed")
//                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Have got an account?",
                color = colorResource(R.color.primaryColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 28.dp)
                    .clickable {
                        navController.navigate("login")
                    },
                textAlign = TextAlign.Center
            )
        }
    }
}
