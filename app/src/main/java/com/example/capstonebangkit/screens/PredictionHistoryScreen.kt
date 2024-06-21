//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import com.example.capstonebangkit.data.local.SharedPreferencesManager
//import com.example.capstonebangkit.data.model.HistoryData
//import com.example.capstonebangkit.ui.auth.QuestionViewModel
//
//@Composable
//fun PredictionHistoryScreen(navController: NavController, viewModel: QuestionViewModel = viewModel()) {
//    val historyList = viewModel.history.collectAsState().value
//    val sharedPreferencesManager = SharedPreferencesManager(navController.context)
//    val email = sharedPreferencesManager.getEmail() ?: ""
//    val filteredHistory = historyList.filter { it.email == email }
//
//    Column {
//        Text(text = "Prediction History")
//        LazyColumn {
//            items(filteredHistory) { history ->
//                PredictionHistoryItem(history)
//            }
//        }
//    }
//}
//
//@Composable
//fun PredictionHistoryItem(historyData: HistoryData) {
//    Column {
//        Text(text = "Email: ${historyData.email}")
//        Text(text = "Label: ${historyData.label}")
//        Text(text = "Created At: ${historyData.createdAt}")
//    }
//}

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.capstonebangkit.R
import com.example.capstonebangkit.components.ButtonComponent
import com.example.capstonebangkit.components.HeadingTextComponent
import com.example.capstonebangkit.components.NormalTextComponent
import com.example.capstonebangkit.data.local.SharedPreferencesManager
import com.example.capstonebangkit.data.model.HistoryData
import com.example.capstonebangkit.ui.auth.QuestionViewModel

@Composable
fun PredictionHistoryScreen(navController: NavController, viewModel: QuestionViewModel = viewModel()) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        val historyList = viewModel.history.collectAsState().value
        val sharedPreferencesManager = SharedPreferencesManager(navController.context)
        val email = sharedPreferencesManager.getEmail() ?: ""
        val filteredHistory = historyList.filter { it.email == email }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(16.dp)
        ) {
            HeadingTextComponent("Prediction History")
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 16.dp)
            ) {
                items(filteredHistory) { history ->
                    PredictionHistoryItem(history)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
            ButtonComponent("Back to Prediction") {
                navController.navigate("homescreen")
            }
        }
    }
}

@Composable
fun PredictionHistoryItem(historyData: HistoryData) {
    Column(
        modifier = Modifier
            .height(intrinsicSize = IntrinsicSize.Min)
            .background(colorResource(id = R.color.darkgreen), RoundedCornerShape(8.dp))
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {

        NormalTextWhiteComponent("Email: ${historyData.email}")
        NormalTextWhiteComponent("Label: ${historyData.label}")
        NormalTextWhiteComponent("Created At: ${historyData.createdAt}")
    }
}

@Composable
fun NormalTextWhiteComponent(value:String) {
    Text(
        text = value,
        modifier = Modifier.fillMaxWidth().heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal
        ),
        color = colorResource(id = R.color.white),
        textAlign = TextAlign.Center
    )
}