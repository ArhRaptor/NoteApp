package com.example.noteapplication.db

import android.content.Context
import androidx.room.Room

object DataBase {
    var userDao: UserDao? = null
    var noteDao: NoteDao? = null
    private var dataBase: AppDataBase? = null

    fun init(context: Context){
        if (dataBase == null){
            dataBase = Room.databaseBuilder(context, AppDataBase::class.java, "noteDataBase").build()
            userDao = dataBase?.userDao()
            noteDao = dataBase?.noteDao()
        }
    }
}