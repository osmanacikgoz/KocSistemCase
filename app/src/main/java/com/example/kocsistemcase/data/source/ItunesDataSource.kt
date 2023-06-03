package com.example.kocsistemcase.data.source

import androidx.paging.PagingData
import com.example.kocsistemcase.data.dto.ItunesResponse
import kotlinx.coroutines.flow.Flow

interface ItunesDataSource {
    fun getItunes(): Flow<PagingData<ItunesResponse.Result>>
}