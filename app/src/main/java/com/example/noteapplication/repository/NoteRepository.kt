package com.example.noteapplication.repository

import com.example.noteapplication.db.NotesStorage
import com.example.noteapplication.model.Note

class NoteRepository {

    fun addNote(note: Note) {
        NotesStorage.notesList.add(note)
    }

    fun getNotesList(): ArrayList<Note> {
        return NotesStorage.notesList
    }
}