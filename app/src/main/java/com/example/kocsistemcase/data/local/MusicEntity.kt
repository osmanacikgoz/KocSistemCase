package com.example.kocsistemcase.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "music")
data class MusicEntity(
    @PrimaryKey
    val trackId:Int,
    val artistId: Int? = null,
    val artistName: String? = null,
    val artistViewUrl: String? = null,
    val artworkUrl100: String? = null,
    val releaseDate: String? = null,
    val collectionPrice: Double? = null,
    val trackName: String? = null,
    val collectionCensoredName:String?=null

)
