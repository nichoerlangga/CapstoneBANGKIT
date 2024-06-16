package com.example.capstonebangkit.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstonebangkit.R

@Composable
fun NormalTextComponent(value:String) {
    Text(
        text = value,
        modifier = Modifier.fillMaxWidth().heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value:String) {
    Text(
        text = value,
        modifier = Modifier.fillMaxWidth().heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(labelValue: String, painter: Painter) {
    val textValue = remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth().heightIn(min = 56.dp),
        label = {Text(text = labelValue)},
        value = textValue.value,
        colors = outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary)
        ),
        keyboardOptions = KeyboardOptions.Default,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(
                painter = painter,
                contentDescription = "icon",
                modifier = Modifier.size(18.dp) // Adjust the size as needed
            )
        }
    )
}