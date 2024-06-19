package com.example.capstonebangkit.components

import androidx.compose.foundation.ExperimentalFoundationApi
import com.example.capstonebangkit.data.model.Questions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstonebangkit.R
import com.example.capstonebangkit.ui.auth.QuestionViewModel
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun ImageCarousel(items: List<Questions>, modifier: Modifier = Modifier, viewModel: QuestionViewModel) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    var answersList = List(70) { 0 }
    val mutableAnswersList = answersList.toMutableList()

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalPager(
            state = pagerState,
            count = items.size + 1, // Increase the count by 1 for the additional page
            modifier = Modifier.fillMaxWidth().height(700.dp),
        ) { page ->
            if (page < items.size) {
                Question(items[page], mutableAnswersList, page)
            } else {
                answersList = mutableAnswersList.toList()
                SubmitPage(viewModel.inputPrediction(answersList, "john.tyler@examplepetstore.com")) // Handle the additional page
            }
        }

        // Optional: Display indicators
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            (0 until items.size + 1).forEach { index ->
                val color = if (index == pagerState.currentPage) Color.Blue else Color.Gray
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .padding(2.dp)
                        .background(color, CircleShape)
                )
            }
        }

        // Optional: Add buttons to navigate the carousel
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage((pagerState.currentPage - 1).coerceAtLeast(0))
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.darkgreen),
                    contentColor = colorResource(id = R.color.primaryColor)
                )
            ) {
                Text("Previous")
            }
            Button(
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage((pagerState.currentPage + 1).coerceAtMost(items.size))
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.darkgreen),
                    contentColor = colorResource(id = R.color.primaryColor)
                )
            ) {
                Text("Next")
            }
        }
    }
}

@Composable
fun SubmitPage(viewModel: Unit) {
    // Define the content of the additional page here
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Image(
                painter = painterResource(id = R.drawable.healhub),
                contentDescription = "Carousel Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )

            HeadingTextComponent(value = "Are you sure the informations you have entered is correct?")
            ButtonComponent(value = "Submit") {

            }
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}


@Composable
fun RadioButtonComponent(answersList: MutableList<Int>, index: Int, options: List<String>, selectedOption: MutableState<String?>, onOptionSelected: (String) -> Unit) {
    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        options.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { onOptionSelected(option) }
            ) {
                RadioButton(
                    selected = selectedOption.value == option,
                    onClick = {
                        onOptionSelected(option)
                        if (option == "Yes") {
                            answersList[index] = 1
                        } else {
                            answersList[index] = 0
                        }
                      },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = colorResource(id = R.color.primaryColor),
                        unselectedColor = Color.Gray
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = option,
                    style = MaterialTheme.typography.body1,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun Question(item: Questions, answersList: MutableList<Int>, index : Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = item.image,
            contentDescription = "Carousel Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            items(item.title.value) { title ->
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(colorResource(id = R.color.darkgreen), RoundedCornerShape(8.dp))
                        .padding(start = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title.question,
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier.width(200.dp)
                    )
                    RadioButtonComponent(
                        answersList = answersList,
                        index = index,
                        options = item.options,
                        selectedOption = title.selectedOption,
                        onOptionSelected = { selectedOption ->
                            title.selectedOption.value = selectedOption
                        }
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
            }
        }
    }
}