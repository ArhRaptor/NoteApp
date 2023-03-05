package com.example.noteapplication.ui.profile

import androidx.lifecycle.ViewModel
import com.example.noteapplication.repository.NoteRepository

class ProfileViewModel: ViewModel() {

    val repository = NoteRepository()

    fun countNotes() : Int = repository.getCountNotes()

    fun deleteAllNotes() {
        repository.deleteAllNotes()
    }

}