package com.example.kocsistemcase.domain.usecase

import com.example.kocsistemcase.domain.repository.MusicRepository
import javax.inject.Inject

class MusicDetailUseCase @Inject constructor(
    private val musicRepository: MusicRepository
){
  operator fun invoke(trackId:Int) = musicRepository.getDetailMusic(trackId)
}