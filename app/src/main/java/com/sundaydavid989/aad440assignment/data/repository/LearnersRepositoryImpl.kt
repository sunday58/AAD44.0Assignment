package com.sundaydavid989.aad440assignment.data.repository

import androidx.lifecycle.LiveData
import com.sundaydavid989.aad440assignment.data.db.LearnersDao
import com.sundaydavid989.aad440assignment.data.entity.Hours
import com.sundaydavid989.aad440assignment.data.network.LearnersNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LearnersRepositoryImpl(
    private val learnersDao: LearnersDao,
    private val learnersNetworkDataSource: LearnersNetworkDataSource
) : LearnersRepository {

    init {
        learnersNetworkDataSource.downloadLearnersHours.observeForever {hours->
            persistFetchedHours(hours)
        }
    }

    override suspend fun getHours(): LiveData<Hours> {
       return withContext(Dispatchers.IO) {
           return@withContext learnersDao.getHours()
       }
    }

    private fun persistFetchedHours(fetchedHours: Hours){
        GlobalScope.launch(Dispatchers.IO){
            learnersDao.upSert(fetchedHours)
        }
    }
}