package com.example.noteapplication.ui.dashboard.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.noteapplication.repository.NoteRepository
import javax.inject.Inject

class SearchViewModelProvider @Inject constructor(
    private val noteRepository: NoteRepository
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return SearchViewModel(noteRepository) as T
    }
}