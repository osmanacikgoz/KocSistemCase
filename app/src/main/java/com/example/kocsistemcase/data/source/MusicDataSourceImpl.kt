package com.example.kocsistemcase.data.source

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.kocsistemcase.data.api.ApiServices
import com.example.kocsistemcase.data.dto.MusicResponse
import com.example.kocsistemcase.data.repository.MusicPagingDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MusicDataSourceImpl @Inject constructor(
    private val apiServices: ApiServices
) : MusicDataSource {
    override fun getItunes(): Flow<PagingData<MusicResponse.Result>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20
            ),
            pagingSourceFactory = {MusicPagingDataSource(apiServices)}
        ).flow
    }
}