package com.example.noteapplication.db

import com.example.noteapplication.model.Note
import kotlin.collections.ArrayList

object NotesStorage {
    var notesList = ArrayList<Note>()
}