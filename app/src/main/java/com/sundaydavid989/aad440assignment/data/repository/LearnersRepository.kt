package com.sundaydavid989.aad440assignment.data.repository

import androidx.lifecycle.LiveData
import com.sundaydavid989.aad440assignment.data.entity.HoursItem
import com.sundaydavid989.aad440assignment.data.entity.SkillItem

interface LearnersRepository {
    suspend fun getHours(): LiveData<out List<HoursItem>>
    suspend fun getSkillIQ(): LiveData<out List<SkillItem>>
}