package com.example.noteapplication.ui.authorization

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapplication.model.User
import com.example.noteapplication.repository.UserPreferencesRepository
import com.example.noteapplication.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthorizationViewModel(
    private val userRepository: UserRepository,
    private val preferencesRepository: UserPreferencesRepository
) : ViewModel() {

    val user = MutableLiveData<User>()

    fun getUser(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            user.postValue(userRepository.getUser(email))
        }
    }

    fun login() {
        preferencesRepository.login()
    }

    fun putUser(user: User) {
        preferencesRepository.putUser(user)
    }
}