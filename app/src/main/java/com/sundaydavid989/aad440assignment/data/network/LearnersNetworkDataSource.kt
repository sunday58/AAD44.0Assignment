package com.sundaydavid989.aad440assignment.data.network

import androidx.lifecycle.LiveData
import com.sundaydavid989.aad440assignment.data.entity.HoursItem
import com.sundaydavid989.aad440assignment.data.entity.SkillItem

interface LearnersNetworkDataSource {
    val downloadLearnersHours: LiveData<Array<HoursItem>>
    val downloadLearnersSkillIQ: LiveData<Array<SkillItem>>

    suspend fun fetchHours()
    suspend fun fetchSkillIQ()
}