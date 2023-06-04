package com.example.kocsistemcase.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "music")
data class MusicEntity(
    @PrimaryKey
    val artistId: Int,
    val artistName: String,
    val artistViewUrl: String,
    val artworkUrl100: String,
)
