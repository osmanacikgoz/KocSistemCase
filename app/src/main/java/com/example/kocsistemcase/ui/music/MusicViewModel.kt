package com.example.kocsistemcase.ui.music

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.kocsistemcase.data.dto.MusicResponse
import com.example.kocsistemcase.domain.usecase.MusicUseCase
import com.example.kocsistemcase.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicViewModel @Inject constructor(
    private val musicUseCase: MusicUseCase
) :BaseViewModel(){
    private val _musicResponse = MutableLiveData<PagingData<MusicResponse.Result>>()
    val musicResponse get() = _musicResponse

    init {
        viewModelScope.launch {
            musicUseCase.invoke().cachedIn(viewModelScope).collectLatest {
                _musicResponse.postValue(it)
            }
        }
    }
}