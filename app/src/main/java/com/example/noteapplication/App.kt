package com.example.noteapplication

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.noteapplication.di.AppModule
import com.example.noteapplication.di.ApplicationComponent
import com.example.noteapplication.di.DaggerApplicationComponent
import com.example.noteapplication.di.DataBaseModule


class App :Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        applicationComponent = DaggerApplicationComponent.builder()
            .appModule(AppModule(this))
            .dataBaseModule(DataBaseModule())
            .build()
    }

    companion object{
        var applicationComponent: ApplicationComponent? = null
    }
}