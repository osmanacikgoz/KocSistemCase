package com.example.kocsistemcase.ui.price

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kocsistemcase.data.local.MusicEntity
import com.example.kocsistemcase.domain.usecase.PriceListUseCase
import com.example.kocsistemcase.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PriceViewModel @Inject constructor(
    private val priceListUseCase: PriceListUseCase
) :BaseViewModel(){

    private val _priceMusicList = MutableLiveData<List<MusicEntity>>()
    val priceMusicList  get() = _priceMusicList

    init {
        viewModelScope.launch {
            val priceList = priceListUseCase.invoke(Unit)
            _priceMusicList.postValue(priceList)
        }
    }
}