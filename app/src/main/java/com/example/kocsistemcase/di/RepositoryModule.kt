package com.example.kocsistemcase.di

import com.example.kocsistemcase.data.repository.ItunesRepository
import com.example.kocsistemcase.data.repository.ItunesRepositoryImpl
import com.example.kocsistemcase.data.source.ItunesDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideItunesRepository(itunesDataSource: ItunesDataSource): ItunesRepository {
        return ItunesRepositoryImpl(itunesDataSource)
    }
}