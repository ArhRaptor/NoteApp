package com.example.noteapplication.repository

import com.example.noteapplication.db.DataBase
import com.example.noteapplication.model.Note

class NoteRepository {

    suspend fun addNote(note: Note) =  DataBase.noteDao?.addNote(note)

    suspend fun getNotesList(userId: Long?): List<Note>? = DataBase.noteDao?.getNotes(userId)

    suspend fun deleteNote(note: Note) = DataBase.noteDao?.deleteNote(note)

    suspend fun deleteAllNotes(userId: Long?) = DataBase.noteDao?.deleteAllNotes(userId)

    suspend fun findNote(text: String): List<Note>? = DataBase.noteDao?.findNote(text)
}