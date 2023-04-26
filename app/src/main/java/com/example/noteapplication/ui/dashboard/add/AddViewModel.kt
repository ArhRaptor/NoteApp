package com.example.noteapplication.ui.dashboard.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapplication.model.Note
import com.example.noteapplication.model.User
import com.example.noteapplication.repository.NoteRepository
import com.example.noteapplication.repository.UserPreferencesRepository
import com.example.noteapplication.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val noteRepository: NoteRepository,
    private val preferencesRepository: UserPreferencesRepository
) : ViewModel() {

    val userId = MutableLiveData<Long>()

    fun addNote(note:Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.addNote(note)
        }
    }

    fun getUserId(email: String){
        viewModelScope.launch(Dispatchers.IO){
            userId.postValue(userRepository.getUserId(email))
        }
    }

    fun getUser(): User? = preferencesRepository.getUser()
}
