package com.example.kocsistemcase.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kocsistemcase.data.local.MusicEntity
import com.example.kocsistemcase.domain.usecase.DeleteMusicUseCase
import com.example.kocsistemcase.domain.usecase.MusicDetailUseCase
import com.example.kocsistemcase.domain.usecase.PriceListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val musicDetailUseCase: MusicDetailUseCase
):ViewModel() {
    private val _musicDetail:MutableStateFlow<MusicEntity?> = MutableStateFlow(null)
    val musicDetail:StateFlow<MusicEntity?> = _musicDetail

    fun musicDetail(trackId:Int){
        viewModelScope.launch {
            musicDetailUseCase.invoke(trackId).collect{
                _musicDetail.value = it
            }
        }
    }


}