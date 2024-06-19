package com.example.capstonebangkit.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.capstonebangkit.R
import com.example.capstonebangkit.components.ImageCarousel
import com.example.capstonebangkit.data.model.Questions
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.capstonebangkit.data.model.Question
import com.example.capstonebangkit.ui.auth.QuestionViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun QuestionOne(viewModel: QuestionViewModel = QuestionViewModel()) {
    val imageList = listOf(
        Questions(
            image = painterResource(R.drawable.healhub),
            title = mutableStateOf (
                mutableListOf(
                    Question("Apakah anda mengalami gatal - gatal?"),
                    Question("Apakah anda mengalami ruam kulit?"),
                    Question("Apakah anda mengalami erupsi kulit?"),
                    Question("Apakah anda mengalami bersin terus menerus?"),
                    Question("Apakah anda mengalami menggigil?"),
                    Question("Apakah anda mengalami demam?")
                )
            )
        ),
        Questions(
            image = painterResource(R.drawable.healhub),
            title = mutableStateOf (
                mutableListOf(
                    Question("Apakah anda mengalami gatal - gatal?"),
                    Question("Apakah anda mengalami ruam kulit?"),
                    Question("Apakah anda mengalami erupsi kulit?"),
                    Question("Apakah anda mengalami bersin terus menerus?"),
                    Question("Apakah anda mengalami menggigil?"),
                    Question("Apakah anda mengalami demam?")
                )
            )
        ),
        Questions(
            image = painterResource(R.drawable.healhub),
            title = mutableStateOf (
                mutableListOf(
                    Question("Apakah anda mengalami gatal - gatal?"),
                    Question("Apakah anda mengalami ruam kulit?"),
                    Question("Apakah anda mengalami erupsi kulit?"),
                    Question("Apakah anda mengalami bersin terus menerus?"),
                    Question("Apakah anda mengalami menggigil?"),
                    Question("Apakah anda mengalami demam?")
                )
            )
        ),
        Questions(
            image = painterResource(R.drawable.healhub),
            title = mutableStateOf (
                mutableListOf(
                    Question("Apakah anda mengalami gatal - gatal?"),
                    Question("Apakah anda mengalami ruam kulit?"),
                    Question("Apakah anda mengalami erupsi kulit?"),
                    Question("Apakah anda mengalami bersin terus menerus?"),
                    Question("Apakah anda mengalami menggigil?"),
                    Question("Apakah anda mengalami demam?")
                )
            )
        ),
        Questions(
            image = painterResource(R.drawable.healhub),
            title = mutableStateOf (
                mutableListOf(
                    Question("Apakah anda mengalami gatal - gatal?"),
                    Question("Apakah anda mengalami ruam kulit?"),
                    Question("Apakah anda mengalami erupsi kulit?"),
                    Question("Apakah anda mengalami bersin terus menerus?"),
                    Question("Apakah anda mengalami menggigil?"),
                    Question("Apakah anda mengalami demam?")
                )
            )
        ),
        Questions(
            image = painterResource(R.drawable.healhub),
            title = mutableStateOf (
                mutableListOf(
                    Question("Apakah anda mengalami gatal - gatal?"),
                    Question("Apakah anda mengalami ruam kulit?"),
                    Question("Apakah anda mengalami erupsi kulit?"),
                    Question("Apakah anda mengalami bersin terus menerus?"),
                    Question("Apakah anda mengalami menggigil?"),
                    Question("Apakah anda mengalami demam?")
                )
            )
        ),
        Questions(
            image = painterResource(R.drawable.healhub),
            title = mutableStateOf (
                mutableListOf(
                    Question("Apakah anda mengalami gatal - gatal?"),
                    Question("Apakah anda mengalami ruam kulit?"),
                    Question("Apakah anda mengalami erupsi kulit?"),
                    Question("Apakah anda mengalami bersin terus menerus?"),
                    Question("Apakah anda mengalami menggigil?"),
                    Question("Apakah anda mengalami demam?")
                )
            )
        ),
    )
    Surface (
        color = Color.White,
        modifier = Modifier.fillMaxSize().background(Color.White).padding(28.dp)
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        ImageCarousel(items = imageList, modifier = Modifier.fillMaxSize(), viewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCarousel() {
    QuestionOne()
}