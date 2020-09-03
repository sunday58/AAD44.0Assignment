package com.sundaydavid989.aad440assignment.data.repository

import androidx.lifecycle.LiveData
import com.sundaydavid989.aad440assignment.data.entity.Hours

interface LearnersRepository {
    suspend fun getHours(): LiveData<Hours>
}