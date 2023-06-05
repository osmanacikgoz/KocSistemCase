package com.example.kocsistemcase.ui

import androidx.lifecycle.viewModelScope
import com.example.kocsistemcase.data.local.MusicEntity
import com.example.kocsistemcase.domain.usecase.MusicUseCase
import com.example.kocsistemcase.ui.base.BaseViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MusicDbViewModel @Inject constructor(
    private val musicUseCase: MusicUseCase
) : BaseViewModel() {
    fun musicDbList(musicDb: List<MusicEntity>) {
        viewModelScope.launch {
            musicUseCase.musicDb(musicDb)
        }
    }

    fun deleteMusic(musicId: Int): Flow<MusicEntity> {
        return musicUseCase.deleteMusic(musicId)
    }
}