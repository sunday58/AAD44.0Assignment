package com.sundaydavid989.aad440assignment.data.network

import com.sundaydavid989.aad440assignment.Constants
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SubmitApiService {

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun submitAssignment(
        @Field("entry.1877115667")firstName: String,
        @Field("entry.2006916086")lastName: String,
        @Field("entry.1824927963")emailAddress: String,
        @Field("entry.284483984")linkToProject: String
    ): Call<Void>

  companion object ServiceBuilder {
       private val client = OkHttpClient.Builder().build()

       private val retrofit = Retrofit.Builder()
           .baseUrl(Constants.SUBMIT_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .client(client)
           .build()

       fun <T> buildService(service: Class<T>): T{
           return retrofit.create(service)
       }
   }
}