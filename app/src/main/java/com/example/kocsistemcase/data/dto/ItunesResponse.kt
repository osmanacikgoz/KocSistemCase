package com.example.kocsistemcase.data.dto


import com.google.gson.annotations.SerializedName

data class ItunesResponse(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val results: List<Result>
)