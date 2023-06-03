package com.example.kocsistemcase.data.repository

import androidx.paging.PagingData
import com.example.kocsistemcase.data.dto.ItunesResponse
import com.example.kocsistemcase.data.source.ItunesDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class ItunesRepositoryImpl @Inject constructor(
    private val itunesDataSource: ItunesDataSource
) : ItunesRepository {
    override fun getItunes(): Flow<PagingData<ItunesResponse.Result>> {
        return itunesDataSource.getItunes()
    }
}