package com.example.kocsistemcase.di

import com.example.kocsistemcase.data.api.ApiServices
import com.example.kocsistemcase.data.local.MusicDao
import com.example.kocsistemcase.data.source.MusicDataSource
import com.example.kocsistemcase.data.source.MusicDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SourceModule {

    @Provides
    @Singleton
    fun provideDataSource(apiServices: ApiServices,musicDao:MusicDao): MusicDataSource {
        return MusicDataSourceImpl(apiServices,musicDao)
    }
}