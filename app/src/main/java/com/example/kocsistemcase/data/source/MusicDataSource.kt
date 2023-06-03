package com.example.kocsistemcase.data.source

import androidx.paging.PagingData
import com.example.kocsistemcase.data.dto.MusicResponse
import kotlinx.coroutines.flow.Flow

interface MusicDataSource {
    fun getItunes(): Flow<PagingData<MusicResponse.Result>>
}