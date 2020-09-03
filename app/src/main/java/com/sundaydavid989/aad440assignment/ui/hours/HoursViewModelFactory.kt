package com.sundaydavid989.aad440assignment.ui.hours

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sundaydavid989.aad440assignment.data.repository.LearnersRepository


@Suppress("UNCHECKED_CAST")
class HoursViewModelFactory(
   private val learnersRepository: LearnersRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HoursViewModel(learnersRepository) as T
    }
}