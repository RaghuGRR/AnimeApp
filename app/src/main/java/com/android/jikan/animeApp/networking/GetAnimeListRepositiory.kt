package com.android.jikan.animeApp.networking

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.jikan.animeApp.helpers.UiState

interface GetAnimeListInf {
    suspend fun getAnimeList(): LiveData<UiState>?
}
class GetAnimeListRepository(): GetAnimeListInf {
    override suspend fun getAnimeList(): LiveData<UiState> {
        val result = RetrofitBuilder.apiService.getAnimeList()
        return if (result.isSuccessful) {
            Log.d("GetAnimeListRepository", "getAnimeList:${result.body()} ")
            MutableLiveData(UiState.Success(result.body()))
        }
        else{
            Log.d("GetAnimeListRepository", "getAnimeList: ${result.message()}")
            MutableLiveData(UiState.Error(result.code(),result.message()))
        }
    }

}
