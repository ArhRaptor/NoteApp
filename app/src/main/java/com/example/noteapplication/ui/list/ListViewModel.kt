package com.example.noteapplication.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.noteapplication.model.Note
import com.example.noteapplication.repository.NoteRepository

class ListViewModel:ViewModel() {

    val noteList = MutableLiveData<ArrayList<Note>>()
    private val repository = NoteRepository()

    fun loadNotes() {
        noteList.value = repository.getNotesList()
    }
}