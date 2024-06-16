package com.example.capstonebangkit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.capstonebangkit.R
import com.example.capstonebangkit.components.HeadingTextComponent
import com.example.capstonebangkit.components.MyTextField
import com.example.capstonebangkit.components.NormalTextComponent

@Composable
fun SignUpScreen() {
    Surface (
        color = Color.White,
        modifier = Modifier.fillMaxSize().background(Color.White).padding(28.dp)
    ) {
        Column (modifier = Modifier.fillMaxWidth()) {
            NormalTextComponent(value = "Hey, there")
            HeadingTextComponent(value = "Create an Account")
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(labelValue = "Full Name", painter = painterResource(id = R.drawable.user))
            MyTextField(labelValue = "Email", painter = painterResource(id = R.drawable.email))
            MyTextField(labelValue = "Password", painter = painterResource(id = R.drawable.password))
            MyTextField(
                labelValue = "Confirm Password",
                painter = painterResource(id = R.drawable.password)
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
    SignUpScreen()

}