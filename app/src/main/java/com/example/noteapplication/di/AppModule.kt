package com.example.noteapplication.di

import android.content.Context
import com.example.noteapplication.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return app.applicationContext
    }
}