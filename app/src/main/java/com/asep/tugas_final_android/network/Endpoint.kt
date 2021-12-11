package com.asep.tugas_final_android.network

import com.asep.tugas_final_android.model.DataNews
import retrofit2.Response
import retrofit2.http.GET

interface Endpoint {

    @GET("v2/top-headlines?country=id&apiKey=20cc7b703af1439c944bccbe9c8d46cf")
    suspend fun getNews(): Response<DataNews>

}