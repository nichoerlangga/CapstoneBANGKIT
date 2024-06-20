//package com.example.capstonebangkit.ui.auth
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.capstonebangkit.data.model.AuthResponse
//import com.example.capstonebangkit.data.repository.AuthRepository
//import kotlinx.coroutines.launch
//
//class AuthViewModel : ViewModel() {
//    private val repository = AuthRepository()
//
//    private val _loginResult = MutableLiveData<AuthResponse?>()
//    val loginResult: LiveData<AuthResponse?> get() = _loginResult
//
//    private val _signUpResult = MutableLiveData<AuthResponse?>()
//    val signUpResult: LiveData<AuthResponse?> get() = _signUpResult
//
//    fun login(email: String, password: String) {
//        viewModelScope.launch {
//            repository.login(email, password) {
//                _loginResult.postValue(it)
//            }
//        }
//    }
//
//    fun signUp(email: String, password: String, username: String) {
//        viewModelScope.launch {
//            repository.signUp(email, password, username) {
//                _signUpResult.postValue(it)
//            }
//        }
//    }
//}

package com.example.capstonebangkit.ui.auth

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.capstonebangkit.data.model.AuthResponse
import com.example.capstonebangkit.data.repository.AuthRepository
import com.example.capstonebangkit.data.local.SharedPreferencesManager
import kotlinx.coroutines.launch

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = AuthRepository()
    private val prefsManager = SharedPreferencesManager(application)

    private val _loginResult = MutableLiveData<AuthResponse?>()
    val loginResult: LiveData<AuthResponse?> get() = _loginResult

    private val _signUpResult = MutableLiveData<AuthResponse?>()
    val signUpResult: LiveData<AuthResponse?> get() = _signUpResult

    private val _email = MutableLiveData<String?>()
    val email: LiveData<String?> get() = _email

    init {
        _email.value = prefsManager.getEmail()
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            repository.login(email, password) {
                _loginResult.postValue(it)
                if (it != null) {
                    _email.postValue(email)
                    prefsManager.clearEmail()
                    prefsManager.saveEmail(email)  // Save email in SharedPreferences
                }
            }
        }
    }

    fun signUp(email: String, password: String, username: String) {
        viewModelScope.launch {
            repository.signUp(email, password, username) {
                _signUpResult.postValue(it)
                if (it != null) {
                    _email.postValue(email)
                    prefsManager.saveEmail(email)  // Save email in SharedPreferences
                }
            }
        }
    }

    fun logout() {
        prefsManager.clearEmail()
        _email.postValue(null)
    }
}
