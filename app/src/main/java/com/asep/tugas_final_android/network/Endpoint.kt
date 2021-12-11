package com.asep.tugas_final_android.network

import com.asep.tugas_final_android.model.DataNews
import retrofit2.Response
import retrofit2.http.GET

interface Endpoint {

    @GET("v2/top-headlines?country=id&apiKey=b20c0ec3d33f4ed599f61e82a2a7484e")
    suspend fun getNews(): Response<DataNews>

}