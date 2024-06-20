package com.example.capstonebangkit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.capstonebangkit.screens.LoginScreen
import com.example.capstonebangkit.screens.PredictionScreen
import com.example.capstonebangkit.screens.QuestionOne
import com.example.capstonebangkit.screens.SignUpScreen
import com.example.capstonebangkit.ui.auth.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val authViewModel: AuthViewModel = viewModel()
            AppNavigation(navController = navController, authViewModel = authViewModel)
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController, authViewModel: AuthViewModel) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController = navController) }
        composable("signup") { SignUpScreen(navController = navController) }
//        composable("QuestionOne") { QuestionOne() }
        composable("QuestionOne") { QuestionOne(navController = navController) }
        composable("Prediction") { PredictionScreen()}

    }
}


