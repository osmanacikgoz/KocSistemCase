package com.example.kocsistemcase.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [MusicEntity::class],
    version = 1
)
abstract class MusicDatabase : RoomDatabase() {
    abstract val dao: MusicDao
}