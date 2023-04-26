package com.example.noteapplication.ui.dashboard.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.noteapplication.repository.NoteRepository
import com.example.noteapplication.repository.UserPreferencesRepository
import com.example.noteapplication.repository.UserRepository
import javax.inject.Inject

class ListViewModelProvider @Inject constructor(
    private val userRepository: UserRepository,
    private val noteRepository: NoteRepository,
    private val preferencesRepository: UserPreferencesRepository
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return ListViewModel(userRepository, noteRepository, preferencesRepository) as T
    }
}