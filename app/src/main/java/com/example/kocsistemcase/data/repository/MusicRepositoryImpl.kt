package com.example.kocsistemcase.data.repository

import androidx.paging.PagingData
import com.example.kocsistemcase.data.dto.MusicResponse
import com.example.kocsistemcase.data.local.MusicDao
import com.example.kocsistemcase.data.local.MusicEntity
import com.example.kocsistemcase.data.source.MusicDataSource
import com.example.kocsistemcase.domain.repository.MusicRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MusicRepositoryImpl @Inject constructor(
    private val musicDataSource: MusicDataSource,
    private val musicDao: MusicDao
) : MusicRepository {
    override fun getItunes(): Flow<PagingData<MusicResponse.Result>> {
        return musicDataSource.getItunes()
    }
    override suspend fun getMusicList(): List<MusicEntity> {
        return musicDao.getMusicList()
    }

    override suspend fun deleteMusicItem(musicItem: MusicEntity) {
        musicDao.delete(musicItem)
    }


}