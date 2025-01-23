package com.android.jikan.animeApp.helpers

sealed class UiState {
    data object Idle : UiState()
    data object Loading : UiState()
    data class Success<out T>(val result: T) : UiState()
    data class Error(val errorCode: Int?, val message: String) : UiState()
}
