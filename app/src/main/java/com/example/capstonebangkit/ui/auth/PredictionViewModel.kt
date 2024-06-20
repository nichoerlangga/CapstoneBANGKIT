package com.example.capstonebangkit.ui.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstonebangkit.data.model.HistoryData
import com.example.capstonebangkit.data.model.QuestionsResult
import com.example.capstonebangkit.data.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class QuestionViewModel : ViewModel() {
    private val repository = AuthRepository()

    private val _inputData = MutableLiveData<QuestionsResult>()
    val inputData: LiveData<QuestionsResult> get() = _inputData

    fun inputPrediction(answersList: List<Int>, email: String) {
        viewModelScope.launch {
            try {
                Log.d("QuestionViewModel", "Sending data: $answersList, email: $email")
                val result = repository.inputPrediction(answersList, email)
                _inputData.postValue(result)
            } catch (e: Exception) {
                Log.e("QuestionViewModel", "Error sending data", e)
                e.printStackTrace()
            }
        }
    }

    private val _history = MutableStateFlow<List<HistoryData>>(emptyList())
    val history: StateFlow<List<HistoryData>> = _history


    init {
        fetchHistory()
    }

    private fun fetchHistory() {
        viewModelScope.launch {
            repository.fetchHistory()
                .catch { e -> e.printStackTrace() }
                .collect { history ->
                    _history.value = history
                }
        }
    }
}
