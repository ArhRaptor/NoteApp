package com.example.noteapplication.ui.dashboard.profile

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

class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val noteRepository: NoteRepository,
    private val preferencesRepository: UserPreferencesRepository
) : ViewModel() {

    val notesList = MutableLiveData<List<Note>>()
    val userId = MutableLiveData<Long>()
    fun deleteAllNotes(userId:Long) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.deleteAllNotes(userId)
        }
    }

    fun getUser():User? = preferencesRepository.getUser()

    fun exit(){
        preferencesRepository.exit()
    }

    fun getUserId(email: String){
        viewModelScope.launch(Dispatchers.IO){
            userId.postValue(userRepository.getUserId(email))
        }
    }

    fun notes(userId: Long){
        viewModelScope.launch(Dispatchers.IO){
            notesList.postValue(noteRepository.getNotesList(userId))
        }
    }

    fun deleteUser(user: User?){
        viewModelScope.launch(Dispatchers.IO){
            userRepository.deleteUser(user)
        }
    }
}