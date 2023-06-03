package com.example.kocsistemcase.data.source

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.kocsistemcase.data.api.ApiServices
import com.example.kocsistemcase.data.dto.ItunesResponse
import com.example.kocsistemcase.data.repository.ItunesPagingDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItunesDataSourceImpl @Inject constructor(
    private val apiServices: ApiServices
) : ItunesDataSource {
    override fun getItunes(): Flow<PagingData<ItunesResponse.Result>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20
            ),
            pagingSourceFactory = {ItunesPagingDataSource(apiServices)}
        ).flow
    }
}