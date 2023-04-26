package com.example.noteapplication.di

import android.content.Context
import androidx.room.Room
import com.example.noteapplication.db.AppDataBase
import com.example.noteapplication.db.NoteDao
import com.example.noteapplication.db.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideDb(context: Context): AppDataBase{
        return Room.databaseBuilder(context, AppDataBase::class.java, "noteDataBase").build()
    }

    @Provides
    @Singleton
    fun providesUserRepository(app: AppDataBase): UserDao{
        return app.userDao()
    }

    @Provides
    @Singleton
    fun providesNoteRepository(app: AppDataBase): NoteDao{
        return app.noteDao()
    }
}