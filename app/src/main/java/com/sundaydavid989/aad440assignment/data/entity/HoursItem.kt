package com.sundaydavid989.aad440assignment.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "learners_hours")
data class HoursItem(
    val badgeUrl: String,
    val country: String,
    @PrimaryKey(autoGenerate = true)
    val hours: Int,
    val name: String
)