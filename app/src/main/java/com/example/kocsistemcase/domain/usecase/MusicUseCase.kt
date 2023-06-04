package com.example.kocsistemcase.domain.usecase

import androidx.paging.PagingData
import com.example.kocsistemcase.data.dto.MusicResponse
import kotlinx.coroutines.flow.Flow

interface MusicUseCase {
    operator fun invoke(): Flow<PagingData<MusicResponse.Result>>
}