package com.sundaydavid989.aad440assignment.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sundaydavid989.aad440assignment.data.entity.HoursItem
import com.sundaydavid989.aad440assignment.data.entity.SkillItem

@Dao
interface LearnersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upSert(hoursItem: Array<HoursItem>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upSertSkillIQ(skillItem: Array<SkillItem>)

    @Query("SELECT * FROM learners_hours")
    fun getHours(): LiveData<List<HoursItem>>

    @Query("SELECT * FROM learners_skill")
    fun getSkillIQ(): LiveData<List<SkillItem>>

}