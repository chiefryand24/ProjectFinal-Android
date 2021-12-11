package com.asep.tugas_final_android.ui.ListBerita

import android.util.Log
import androidx.lifecycle.ViewModel
import com.asep.tugas_final_android.model.Article
import com.asep.tugas_final_android.model.DataNews
import com.asep.tugas_final_android.network.RetrofitClient
import retrofit2.Response
import java.lang.Exception

class ListBeritaViewModel: ViewModel() {
    private val TAG = "ListBeritaViewModel"

    suspend fun getBerita(adapter: BeritaAdapter) {
        var response: Response<DataNews>? = null
        try {
            response = RetrofitClient.instance.getNews()
            if(response.isSuccessful) {
                adapter.setData(response.body()!!.articles as MutableList<Article>)
            }
        } catch (e: Exception) {
            Log.e(TAG, "${e.message}")
        }
    }

}