package com.example.kocsistemcase.domain.usecase

import androidx.paging.PagingData
import com.example.kocsistemcase.data.dto.MusicResponse
import com.example.kocsistemcase.domain.repository.MusicRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MusicUseCaseImpl @Inject constructor(
    private val musicRepository: MusicRepository
) : MusicUseCase {
    override fun invoke(): Flow<PagingData<MusicResponse.Result>> {
        return musicRepository.getItunes()
    }
}