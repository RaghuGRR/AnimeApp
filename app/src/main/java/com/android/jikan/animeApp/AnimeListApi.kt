package com.android.jikan.animeApp

import retrofit2.Response
import retrofit2.http.GET

interface AnimeListApi {
    @GET("top/anime")
    suspend fun getAnimeList(): Response<AnimeListResponse>
}
