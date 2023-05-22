package com.example.noteapplication.ui.dashboard.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.noteapplication.repository.NoteRepository
import com.example.noteapplication.repository.UserPreferencesRepository
import com.example.noteapplication.repository.UserRepository
import javax.inject.Inject

class AddViewModelProvider @Inject constructor(
    private val userRepository: UserRepository,
    private val noteRepository: NoteRepository,
    private val preferencesRepository: UserPreferencesRepository
): ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return AddViewModel(userRepository, noteRepository, preferencesRepository) as T
    }
}