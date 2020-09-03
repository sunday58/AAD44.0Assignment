package com.sundaydavid989.aad440assignment.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sundaydavid989.aad440assignment.data.entity.Hours
import com.sundaydavid989.aad440assignment.data.entity.HoursItem

@Dao
interface LearnersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upSert(hoursItem: Hours)

    @Query("SELECT * FROM learners_hours")
    fun getHours(): LiveData<List<HoursItem>>
}