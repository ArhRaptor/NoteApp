package com.example.noteapplication.ui.add

import androidx.lifecycle.ViewModel
import com.example.noteapplication.model.Note
import com.example.noteapplication.repository.NoteRepository

class AddViewModel: ViewModel() {

    private val repository = NoteRepository()

    fun addNote(note:Note) {
        repository.addNote(note)
    }
}
