package com.sundaydavid989.aad440assignment.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "learners_skill")
data class SkillItem(
    val badgeUrl: String,
    val country: String,
    val name: String,
    @PrimaryKey(autoGenerate = true)
    val score: Int
)