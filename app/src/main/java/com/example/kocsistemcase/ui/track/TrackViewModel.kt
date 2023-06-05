package com.example.kocsistemcase.ui.track

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kocsistemcase.data.local.MusicDao
import com.example.kocsistemcase.data.local.MusicEntity
import com.example.kocsistemcase.domain.usecase.TrackListMusicUseCase
import com.example.kocsistemcase.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrackViewModel @Inject constructor(
    private val trackListMusicUseCase: TrackListMusicUseCase
):BaseViewModel() {

    private val _trackListResponse = MutableLiveData<List<MusicEntity>>()
    val trackMusicList  get() = _trackListResponse

    init {
        viewModelScope.launch {
             val trackList = trackListMusicUseCase.invoke(Unit)
            _trackListResponse.postValue(trackList)
        }
    }

}