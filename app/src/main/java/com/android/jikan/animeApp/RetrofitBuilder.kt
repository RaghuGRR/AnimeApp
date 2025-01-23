package com.android.jikan.animeApp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = "https://api.jikan.moe/v4/"
    private val retrofitBuilder: Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val apiService: AnimeListApi = retrofitBuilder.create(AnimeListApi::class.java)


}