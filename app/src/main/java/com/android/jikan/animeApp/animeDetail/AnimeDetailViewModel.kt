package com.android.jikan.animeApp.animeDetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.jikan.animeApp.helpers.UiState

class AnimeDetailViewModel : ViewModel() {

    private val _animeDetail = MutableLiveData<UiState>()
    val animeDetail: MutableLiveData<UiState> = _animeDetail
    internal fun getAnimeDetail(animeData: Int?) {
        _animeDetail.value = UiState.Loading
    }
}