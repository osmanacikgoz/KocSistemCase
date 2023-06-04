package com.example.kocsistemcase.domain.repository

import androidx.paging.PagingData
import com.example.kocsistemcase.data.dto.MusicResponse
import com.example.kocsistemcase.data.local.MusicEntity
import kotlinx.coroutines.flow.Flow

interface MusicRepository {
    fun getItunes():Flow<PagingData<MusicResponse.Result>>
    fun getDeleteMusic(musicEntity: MusicEntity)
}