import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.capstonebangkit.data.local.SharedPreferencesManager
import com.example.capstonebangkit.data.model.HistoryData
import com.example.capstonebangkit.ui.auth.QuestionViewModel

@Composable
fun PredictionHistoryScreen(navController: NavController, viewModel: QuestionViewModel = viewModel()) {
    val historyList = viewModel.history.collectAsState().value
    val sharedPreferencesManager = SharedPreferencesManager(navController.context)
    val email = sharedPreferencesManager.getEmail() ?: ""
    val filteredHistory = historyList.filter { it.email == email }

    Column {
        Text(text = "Prediction History")
        LazyColumn {
            items(filteredHistory) { history ->
                PredictionHistoryItem(history)
            }
        }
    }
}

@Composable
fun PredictionHistoryItem(historyData: HistoryData) {
    Column {
        Text(text = "Email: ${historyData.email}")
        Text(text = "Label: ${historyData.label}")
        Text(text = "Created At: ${historyData.createdAt}")
    }
}
