package com.example.noteapplication.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.noteapplication.model.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun addNote(note: Note)

    @Query("SELECT * FROM note_table WHERE user_id = :userId")
    suspend fun getNotes(userId: Long?): List<Note>

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("DELETE FROM note_table WHERE user_id = :userId")
    suspend fun deleteAllNotes(userId: Long?)

    @Query("SELECT * FROM note_table WHERE title LIKE '%' || :text || '%' OR message LIKE '%' || :text || '%'")
    suspend fun findNote(text: String): List<Note>
}