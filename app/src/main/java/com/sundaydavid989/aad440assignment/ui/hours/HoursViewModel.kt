package com.sundaydavid989.aad440assignment.ui.hours

import androidx.lifecycle.ViewModel
import com.sundaydavid989.aad440assignment.data.repository.LearnersRepository
import com.sundaydavid989.aad440assignment.internal.lazyDeferred

class HoursViewModel(
    private val learnersRepository: LearnersRepository
) : ViewModel() {

    val hours by lazyDeferred {
        learnersRepository.getHours()
    }
}