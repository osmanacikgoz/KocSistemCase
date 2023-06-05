package com.example.kocsistemcase.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("search?term=jack+johnson")
    suspend fun getItunes(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): String
}