package com.example.kocsistemcase.domain.usecase

import androidx.paging.PagingData
import com.example.kocsistemcase.data.dto.MusicResponse
import com.example.kocsistemcase.data.local.MusicEntity
import kotlinx.coroutines.flow.Flow

interface MusicUseCase {
     fun invoke(): Flow<PagingData<MusicResponse.Result>>

    fun musicDb(music:List<MusicEntity>):Flow<List<MusicEntity>>

    fun deleteMusic(musicId: Int):Flow<MusicEntity>
}