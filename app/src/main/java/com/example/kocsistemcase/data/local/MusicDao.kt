package com.example.kocsistemcase.data.local

import androidx.room.*

@Dao
interface MusicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(itunesList: List<MusicEntity>)

    @Query("SELECT * FROM music")
    suspend fun getMusicList(): List<MusicEntity>

    @Delete
    suspend fun delete(musicEntity: MusicEntity)
}