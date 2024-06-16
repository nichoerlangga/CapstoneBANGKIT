package com.example.capstonebangkit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.capstonebangkit.app.CapstoneBangkit
import com.example.capstonebangkit.screens.CarouselPreview
import com.example.capstonebangkit.screens.LoginScreen
import com.example.capstonebangkit.screens.SignUpScreen
import com.example.capstonebangkit.ui.theme.CapstoneBANGKITTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarouselPreview()
        }
    }
}

