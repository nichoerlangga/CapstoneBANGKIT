package com.example.capstonebangkit.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.capstonebangkit.R
import com.example.capstonebangkit.data.local.SharedPreferencesManager
import com.example.capstonebangkit.ui.auth.QuestionViewModel
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun ImageCarousel(items: List<Questions>, modifier: Modifier = Modifier, viewModel: QuestionViewModel, navHostController: NavHostController) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    val answersList = remember { mutableStateListOf<Int>().apply { addAll(List(70) { 0 }) } }
    val selectedItems = remember { mutableStateListOf<String>().apply { addAll(List(items.size) { "Select" }) } }
    val context = LocalContext.current
    val sharedPreferencesManager = SharedPreferencesManager(context)
    val email = sharedPreferencesManager.getEmail() ?: ""

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
                Question(items[page], answersList, selectedItems, page)
            } else {
//                SubmitPage(viewModel,answersList, "byan@gmail.com")
                SubmitPage(viewModel,answersList, email, navHostController)
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
fun SubmitPage(viewModel: QuestionViewModel,answersList: List<Int>, email: String, navController: NavController) {
    val predictionResult by viewModel.inputData.observeAsState()
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

            HeadingTextComponent(value = "Are you sure the information you have entered is correct?")
            ButtonComponent(value = "Submit") {
                viewModel.inputPrediction(answersList, email)
            }
            predictionResult?.let { result ->
                Text("Sign Up Successful! Token: ${result.data.id}")
                LaunchedEffect(Unit) {
                    navController.navigate("Prediction/${result.data.label}")
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}


@Composable
fun Question(item: Questions, answersList: MutableList<Int>, selectedItems: MutableList<String>, pageIndex: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(5.dp))
        Image(
            painter = item.image,
            contentDescription = "Carousel Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        Column(
            modifier = Modifier
                .height(intrinsicSize = IntrinsicSize.Min)
                .background(colorResource(id = R.color.darkgreen), RoundedCornerShape(8.dp))
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            Text(
                text = item.title,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                textAlign = TextAlign.Center
            )
            DropDownMenu(
                options = item.symptomsList,
                initialValue = selectedItems[pageIndex],
                onItemSelected = { selectedIndex, selectedItem ->
                    selectedItems[pageIndex] = selectedItem
                    if (selectedIndex != pageIndex) {
                        answersList[pageIndex] = 0 // Reset previous answer to zero
                    }
                    answersList[selectedIndex] = 1 // Update answersList
                }
            )
        }
    }
}

@Composable
fun DropDownMenu(
    options: List<String>,
    initialValue: String,
    onItemSelected: (selectedIndex: Int, selectedItem: String) -> Unit
) {
    var selectedIndex by remember { mutableStateOf(options.indexOf(initialValue)) }
    var selectedItem by remember { mutableStateOf(initialValue) }
    var expanded by remember { mutableStateOf(false) }

    Column {
        Box(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = true },
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = { expanded = true },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = colorResource(id = R.color.darkgreen),
                        contentColor = LocalContentColor.current
                    ),
                    border = BorderStroke(0.dp, Color.Transparent),
                    shape = MaterialTheme.shapes.small,
                    elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp)
                ) {
                    Text(selectedItem, color = colorResource(id = R.color.primaryColor))
                }

                IconButton(
                    onClick = { expanded = true },
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Dropdown Icon",
                        tint = colorResource(id = R.color.primaryColor)
                    )
                }
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEachIndexed { index, item ->
                    DropdownMenuItem(
                        onClick = {
                            selectedIndex = index
                            selectedItem = item
                            expanded = false
                            onItemSelected(selectedIndex, selectedItem)
                        }
                    ) {
                        Text(item)
                    }
                }
            }
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