package com.example.kocsistemcase.ui.detail

import androidx.lifecycle.ViewModel
import com.example.kocsistemcase.data.local.MusicEntity
import com.example.kocsistemcase.domain.usecase.MusicDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val musicDetailUseCase: MusicDetailUseCase
) : ViewModel() {
    private val _musicDetail: MutableStateFlow<MusicEntity?> = MutableStateFlow(null)
    val musicDetail: StateFlow<MusicEntity?> = _musicDetail

    fun getMusicDetail(trackId: Int): Flow<MusicEntity> = flow {
        musicDetailUseCase.invoke(trackId).collect { musicEntity ->
            emit(musicEntity)
        }
    }.flowOn(Dispatchers.IO)


}