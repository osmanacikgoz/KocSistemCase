package com.example.kocsistemcase.domain.usecase

import com.example.kocsistemcase.data.local.MusicEntity
import com.example.kocsistemcase.domain.repository.MusicRepository
import javax.inject.Inject

class PriceListUseCase @Inject constructor(
    private val musicRepository: MusicRepository
) :BaseUseCase<Unit,List<MusicEntity>>(){
    override suspend fun execute(params: Unit): List<MusicEntity> {
        return musicRepository.getMusicList()
    }
}