package com.example.noteapplication

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.noteapplication.db.DataBase
import com.example.noteapplication.repository.UserPreferencesRepository

class App :Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        UserPreferencesRepository.init(applicationContext)
        DataBase.init(applicationContext)
    }
}