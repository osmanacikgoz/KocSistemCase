package com.example.kocsistemcase.di

import com.example.kocsistemcase.data.api.ApiServices
import com.example.kocsistemcase.data.source.ItunesDataSource
import com.example.kocsistemcase.data.source.ItunesDataSourceImpl
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
    fun provideDataSource(apiServices: ApiServices): ItunesDataSource {
        return ItunesDataSourceImpl(apiServices)
    }
}