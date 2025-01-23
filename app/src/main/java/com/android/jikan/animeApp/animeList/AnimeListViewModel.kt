package com.android.jikan.animeApp.animeList

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.jikan.animeApp.networking.GetAnimeListRepository
import com.android.jikan.animeApp.helpers.UiState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnimeListViewModel : ViewModel() {
    private val _animeList : MutableLiveData<UiState> by lazy {MutableLiveData<UiState>()}
    val animeList: MutableLiveData<UiState> = _animeList
    internal fun getAnimeList() {
        _animeList.value = UiState.Loading
        val exceptionHandler = CoroutineExceptionHandler { _, _ ->
            Log.d("TAG", "getAnimeList: ")
            _animeList.value = UiState.Error(1, "Something went wrong")
        }
        viewModelScope.launch(Dispatchers.IO+exceptionHandler) {
            GetAnimeListRepository().getAnimeList().let{
                _animeList.postValue(it.value)
            }
        }
    }
}