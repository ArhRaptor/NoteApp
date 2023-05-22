package com.example.noteapplication.repository

import com.example.noteapplication.db.NoteDao
import com.example.noteapplication.model.Note
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) {

    suspend fun addNote(note: Note) = noteDao.addNote(note)
    suspend fun getNotesList(userId: Long?): List<Note> = noteDao.getNotes(userId)
    suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)
    suspend fun deleteAllNotes(userId: Long?) = noteDao.deleteAllNotes(userId)
    suspend fun findNote(text: String): List<Note> = noteDao.findNote(text)
}