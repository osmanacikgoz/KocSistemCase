package com.example.kocsistemcase.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MusicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(itunesList: List<MusicEntity>)

    @Query("SELECT * FROM music")
    suspend fun getMusicList(): List<MusicEntity>

    @Query("SELECT * FROM music WHERE trackId = :trackId")
    fun getMusic(trackId:Int):Flow<MusicEntity>

    @Delete
     fun delete(musicEntity: MusicEntity)
}