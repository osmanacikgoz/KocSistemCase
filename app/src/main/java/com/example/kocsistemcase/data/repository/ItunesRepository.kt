package com.example.kocsistemcase.data.repository

import androidx.paging.PagingData
import com.example.kocsistemcase.data.dto.ItunesResponse
import kotlinx.coroutines.flow.Flow

interface ItunesRepository {
    fun getItunes():Flow<PagingData<ItunesResponse.Result>>
}