package com.example.kocsistemcase.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface MusicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(itunesList:List<MusicEntity>)

    @Delete
    fun delete(musicEntity: MusicEntity)
}