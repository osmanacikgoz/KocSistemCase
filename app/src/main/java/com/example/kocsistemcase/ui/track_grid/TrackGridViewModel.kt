package com.example.kocsistemcase.ui.track_grid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kocsistemcase.data.local.MusicEntity
import com.example.kocsistemcase.domain.usecase.GridTrackListMusicUseCase
import com.example.kocsistemcase.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TrackGridViewModel @Inject constructor(
    private val gridTrackListMusicUseCase: GridTrackListMusicUseCase
) : BaseViewModel() {

    private val _trackListResponse = MutableLiveData<List<MusicEntity>>()
    val trackMusicList get() = _trackListResponse

    init {
        viewModelScope.launch {
            val trackGridList = gridTrackListMusicUseCase.invoke(Unit)
            _trackListResponse.postValue(trackGridList)
        }
    }
}