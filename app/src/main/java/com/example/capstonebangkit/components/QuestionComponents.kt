package com.example.capstonebangkit.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import com.example.capstonebangkit.data.model.Questions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstonebangkit.R
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun ImageCarousel(items: List<Questions>, modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween) {
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalPager(
            state = pagerState,
            count = items.size,
            modifier = Modifier.fillMaxWidth().height(300.dp)
        ) { page ->
            val item = items[page]
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = item.image,
                    contentDescription = "Carousel Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = item.title, fontSize = 20.sp, color = Color.Black)
                    RadioButtonComponent(options = item.options)
                }
            }
        }

        // Optional: Display indicators
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            items.forEachIndexed { index, _ ->
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
            Button(onClick = {
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
            Button(onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage((pagerState.currentPage + 1).coerceAtMost(items.size - 1))
                }
            }, colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.darkgreen),
                contentColor = colorResource(id = R.color.primaryColor)
            )) {
                Text("Next")
            }
        }
    }
}

@Composable
fun RadioButtonComponent(options: List<String>) {
    var selectedOption by remember { mutableStateOf(options.firstOrNull() ?: "") }

    Column (
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        options.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { selectedOption = option }
            ) {
                RadioButton(
                    selected = selectedOption == option,
                    onClick = { selectedOption = option },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = colorResource(id = R.color.primaryColor),
                        unselectedColor = Color.Gray
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = option,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}



