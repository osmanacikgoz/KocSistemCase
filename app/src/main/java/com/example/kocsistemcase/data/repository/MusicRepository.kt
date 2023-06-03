package com.example.kocsistemcase.data.repository

import androidx.paging.PagingData
import com.example.kocsistemcase.data.dto.MusicResponse
import kotlinx.coroutines.flow.Flow

interface MusicRepository {
    fun getItunes():Flow<PagingData<MusicResponse.Result>>
}