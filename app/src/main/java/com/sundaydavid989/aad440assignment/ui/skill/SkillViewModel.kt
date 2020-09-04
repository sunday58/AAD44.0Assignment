package com.sundaydavid989.aad440assignment.ui.skill

import androidx.lifecycle.ViewModel
import com.sundaydavid989.aad440assignment.data.network.LearnersNetworkDataSource
import com.sundaydavid989.aad440assignment.data.repository.LearnersRepository
import com.sundaydavid989.aad440assignment.internal.lazyDeferred

class SkillViewModel(
    private val learnersRepository: LearnersRepository
) : ViewModel() {

    val skill by lazyDeferred {
        learnersRepository.getSkillIQ()
    }
}