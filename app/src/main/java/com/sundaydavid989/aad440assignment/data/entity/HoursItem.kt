package com.sundaydavid989.aad440assignment.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "learners_hours")
data class HoursItem(
    @PrimaryKey(autoGenerate = true)
    val badgeUrl: String,
    val country: String,
    val hours: Int,
    val name: String
)