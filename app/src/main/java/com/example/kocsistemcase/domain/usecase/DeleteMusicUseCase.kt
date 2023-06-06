package com.example.kocsistemcase.domain.usecase

import com.example.kocsistemcase.data.local.MusicEntity
import com.example.kocsistemcase.domain.repository.MusicRepository
import javax.inject.Inject

class DeleteMusicUseCase @Inject constructor(
    private val musicRepository: MusicRepository
) {
    operator fun invoke(musicEntity: MusicEntity) = musicRepository.deleteMusicItem(musicEntity)
}