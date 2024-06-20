package com.example.capstonebangkit.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.capstonebangkit.data.model.QuestionsResult
import com.example.capstonebangkit.data.model.inputPrediction
import com.example.capstonebangkit.data.repository.AuthRepository
import kotlinx.coroutines.launch

class QuestionViewModel : ViewModel() {
    private val repository = AuthRepository()

    // LiveData to hold the list of questions' answers as integers
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

}