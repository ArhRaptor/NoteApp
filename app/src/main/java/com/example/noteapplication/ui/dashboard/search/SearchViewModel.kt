package com.example.noteapplication.ui.dashboard.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapplication.model.Note
import com.example.noteapplication.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) :ViewModel() {

    val notesList =MutableLiveData<List<Note>>()

    fun findNote(text :String){
        viewModelScope.launch(Dispatchers.IO) {
            notesList.postValue(noteRepository.findNote(text))
        }
    }
}