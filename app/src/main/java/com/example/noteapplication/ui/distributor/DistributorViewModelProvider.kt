package com.example.noteapplication.ui.distributor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.noteapplication.repository.UserPreferencesRepository
import javax.inject.Inject

class DistributorViewModelProvider @Inject constructor(
    private val preferencesRepository: UserPreferencesRepository
): ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return DistributorViewModel(preferencesRepository) as T
    }
}