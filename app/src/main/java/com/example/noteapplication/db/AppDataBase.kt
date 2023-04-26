package com.example.noteapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.noteapplication.model.Note
import com.example.noteapplication.model.User
import com.example.noteapplication.utils.DateTypeConverter

@Database(entities = [User::class, Note::class], version = 1)
@TypeConverters(DateTypeConverter::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao() : UserDao
    abstract fun noteDao() : NoteDao
}