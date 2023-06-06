package com.example.kocsistemcase.domain.usecase

import com.example.kocsistemcase.data.local.MusicEntity
import com.example.kocsistemcase.domain.repository.MusicRepository
import javax.inject.Inject

class DeleteMusicUseCase @Inject constructor(
    private val musicRepository: MusicRepository
) {
    suspend operator fun invoke(musicEntity: MusicEntity): Int =
        musicRepository.deleteMusicItem(musicEntity)
}