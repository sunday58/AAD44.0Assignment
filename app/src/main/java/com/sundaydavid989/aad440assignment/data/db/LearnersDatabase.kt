package com.sundaydavid989.aad440assignment.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sundaydavid989.aad440assignment.data.entity.HoursItem


@Database(
    exportSchema = false,
    entities = [HoursItem::class],
    version = 1
)
abstract class LearnersDatabase : RoomDatabase() {
    abstract fun learnersDao(): LearnersDao

    companion object {
        @Volatile private var instance: LearnersDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it }
        }
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
            LearnersDatabase::class.java,
            "learners.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}