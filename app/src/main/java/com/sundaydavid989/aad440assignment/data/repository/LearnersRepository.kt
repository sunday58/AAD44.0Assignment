package com.sundaydavid989.aad440assignment.data.repository

import androidx.lifecycle.LiveData
import com.sundaydavid989.aad440assignment.data.entity.HoursItem

interface LearnersRepository {
    suspend fun getHours(): LiveData<out List<HoursItem>>
}