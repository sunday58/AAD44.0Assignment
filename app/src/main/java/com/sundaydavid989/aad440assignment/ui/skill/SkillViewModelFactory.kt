package com.sundaydavid989.aad440assignment.ui.skill

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sundaydavid989.aad440assignment.data.repository.LearnersRepository


@Suppress("UNCHECKED_CAST")
class SkillViewModelFactory(
    private val learnersRepository: LearnersRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SkillViewModel(learnersRepository) as T
    }
}