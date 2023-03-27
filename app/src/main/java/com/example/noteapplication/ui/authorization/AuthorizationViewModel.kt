package com.example.noteapplication.ui.authorization

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapplication.model.User
import com.example.noteapplication.repository.UserPreferencesRepository
import com.example.noteapplication.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthorizationViewModel : ViewModel() {

    val user = MutableLiveData<User>()
    private val repository = UserRepository()
    private val preferencesRepository = UserPreferencesRepository

    fun getUser(email: String) {
        viewModelScope.launch(Dispatchers.IO){
            user.postValue(repository.getUser(email))
        }
    }

    fun login(){
        preferencesRepository.login()
    }

    fun putUser(user: User){
        preferencesRepository.putUser(user)
    }
}