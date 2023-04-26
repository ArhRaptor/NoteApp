package com.example.noteapplication.ui.dashboard.list

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

class ListViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val noteRepository: NoteRepository,
    private val preferencesRepository: UserPreferencesRepository
):ViewModel() {

    val noteList = MutableLiveData<List<Note>>()
    val userId = MutableLiveData<Long>()

    fun loadNotes(userId: Long?) {
        viewModelScope.launch(Dispatchers.IO) {
            noteList.postValue(noteRepository.getNotesList(userId))
        }
    }

    fun getUserId(email: String) {
        viewModelScope.launch(Dispatchers.IO){
            userId.postValue(userRepository.getUserId(email))
        }
    }

    fun getUser(): User? = preferencesRepository.getUser()

    fun deleteNote(note: Note){
        viewModelScope.launch(Dispatchers.IO){
            noteRepository.deleteNote(note)
        }
    }
}