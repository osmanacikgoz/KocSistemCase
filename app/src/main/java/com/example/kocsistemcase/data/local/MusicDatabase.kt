package com.example.kocsistemcase.data.local

import androidx.room.Database


@Database(
    entities = [MusicEntity::class],
    version = 1
)
abstract class MusicDatabase {
    abstract val dao:MusicDao
}