package com.example.noteapplication.ui.distributor

import androidx.lifecycle.ViewModel
import com.example.noteapplication.repository.UserPreferencesRepository
import javax.inject.Inject

class DistributorViewModel @Inject constructor(
    private val preferencesRepository: UserPreferencesRepository
) : ViewModel() {

    fun startApp() {
        preferencesRepository.startApp()
    }
    fun isStartApp(): Boolean = preferencesRepository.isStartApp()
    fun isLogin(): Boolean = preferencesRepository.isLogin()
}