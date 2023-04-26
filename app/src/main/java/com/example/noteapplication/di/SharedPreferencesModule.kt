package com.example.noteapplication.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

private const val USER_PREFERENCES = "userPreferences"

@Module
class SharedPreferencesModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences{
        return context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE)
    }
}