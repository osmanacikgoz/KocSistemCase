package com.example.kocsistemcase.domain.usecase

import androidx.paging.PagingData
import com.example.kocsistemcase.data.dto.MusicResponse
import com.example.kocsistemcase.domain.repository.MusicRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMusicListUseCase @Inject constructor(
    private val musicRepository: MusicRepository
) : BaseUseCase<Unit, Flow<PagingData<MusicResponse.Result>>>() {

    override suspend fun execute(params: Unit): Flow<PagingData<MusicResponse.Result>> {
        return musicRepository.getItunes()
    }

}