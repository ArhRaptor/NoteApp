package com.example.noteapplication.ui.dashboard.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapplication.model.Note
import com.example.noteapplication.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel:ViewModel() {

    val notesList =MutableLiveData<List<Note>>()
    private val noteRepository = NoteRepository()

    fun findNote(text :String){
        viewModelScope.launch(Dispatchers.IO) {
            notesList.postValue(noteRepository.findNote(text))
        }
    }
}