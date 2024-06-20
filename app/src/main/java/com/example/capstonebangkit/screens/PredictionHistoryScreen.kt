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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.capstonebangkit.components.ButtonComponent
import com.example.capstonebangkit.components.HeadingTextComponent
import com.example.capstonebangkit.components.NormalTextComponent
import com.example.capstonebangkit.data.local.SharedPreferencesManager
import com.example.capstonebangkit.data.model.HistoryData
import com.example.capstonebangkit.ui.auth.QuestionViewModel

@Composable
fun PredictionHistoryScreen(navController: NavController, viewModel: QuestionViewModel = viewModel()) {
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
            }
        }
        ButtonComponent("Back to Prediction") {
            navController.navigate("homescreen")
        }
    }
}

@Composable
fun PredictionHistoryItem(historyData: HistoryData) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray)
            .padding(16.dp)
    ) {
        NormalTextComponent("Email: ${historyData.email}")
        NormalTextComponent("Label: ${historyData.label}")
        NormalTextComponent("Created At: ${historyData.createdAt}")
    }
}
