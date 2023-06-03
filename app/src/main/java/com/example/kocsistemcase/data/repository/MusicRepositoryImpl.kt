package com.example.kocsistemcase.data.repository

import androidx.paging.PagingData
import com.example.kocsistemcase.data.dto.MusicResponse
import com.example.kocsistemcase.data.source.MusicDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class MusicRepositoryImpl @Inject constructor(
    private val musicDataSource: MusicDataSource
) : MusicRepository {
    override fun getItunes(): Flow<PagingData<MusicResponse.Result>> {
        return musicDataSource.getItunes()
    }
}