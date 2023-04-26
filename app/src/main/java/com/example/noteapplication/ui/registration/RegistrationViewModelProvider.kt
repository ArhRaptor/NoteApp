package com.example.noteapplication.ui.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.noteapplication.repository.UserPreferencesRepository
import com.example.noteapplication.repository.UserRepository
import javax.inject.Inject

class RegistrationViewModelProvider @Inject constructor(
    private val userRepository: UserRepository,
    private val preferencesRepository: UserPreferencesRepository
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return RegistrationViewModel(userRepository,preferencesRepository) as T
    }
}