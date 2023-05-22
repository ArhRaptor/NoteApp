package com.example.noteapplication.ui.registration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapplication.model.User
import com.example.noteapplication.repository.UserPreferencesRepository
import com.example.noteapplication.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegistrationViewModel @Inject constructor(
    private val repository: UserRepository,
    private val preferencesRepository: UserPreferencesRepository
) : ViewModel() {

    val user = MutableLiveData<User>()


    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun login() {
        preferencesRepository.login()
    }

    fun putUser(user: User) {
        preferencesRepository.putUser(user)
    }

    fun getUser(email: String) {
        viewModelScope.launch(Dispatchers.IO){
            user.postValue(repository.getUser(email))
        }
    }

}