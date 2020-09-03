package com.sundaydavid989.aad440assignment.data.network

import androidx.lifecycle.LiveData
import com.sundaydavid989.aad440assignment.data.entity.Hours
import com.sundaydavid989.aad440assignment.data.entity.HoursItem

interface LearnersNetworkDataSource {
    val downloadLearnersHours: LiveData<Hours>

    suspend fun fetchHours()
}