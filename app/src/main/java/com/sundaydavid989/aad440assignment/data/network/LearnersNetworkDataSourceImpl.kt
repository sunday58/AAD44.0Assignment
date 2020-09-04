package com.sundaydavid989.aad440assignment.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sundaydavid989.aad440assignment.data.entity.Hours
import com.sundaydavid989.aad440assignment.data.entity.HoursItem
import com.sundaydavid989.aad440assignment.internal.NoConnectivityException

class LearnersNetworkDataSourceImpl(
    private val learnersApiService: LearnersApiService
) : LearnersNetworkDataSource {
    private val _downloadLearnersHours = MutableLiveData<Array<HoursItem>>()
    override val downloadLearnersHours: LiveData<Array<HoursItem>>
        get() = _downloadLearnersHours

    override suspend fun fetchHours() {
        try {
            val fetchHours = learnersApiService
                .getHoursAsync()
                .await()
            _downloadLearnersHours.postValue(fetchHours)
            Log.d("Items", _downloadLearnersHours.postValue(fetchHours).toString())
        }
        catch (e: NoConnectivityException){
            Log.d("connectivity ", "No internet connection")
        }
    }
}