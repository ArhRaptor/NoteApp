package com.example.noteapplication.ui.main

import androidx.lifecycle.ViewModel
import com.example.noteapplication.repository.UserPreferencesRepository

class MainViewModel: ViewModel() {

    fun startApp() {
        UserPreferencesRepository.startApp()
    }

    fun isStartApp(): Boolean = UserPreferencesRepository.isStartApp()

    fun isLogin(): Boolean = UserPreferencesRepository.isLogin()
}