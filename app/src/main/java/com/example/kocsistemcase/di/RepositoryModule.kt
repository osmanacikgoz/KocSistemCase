package com.example.kocsistemcase.di

import com.example.kocsistemcase.data.repository.MusicRepository
import com.example.kocsistemcase.data.repository.MusicRepositoryImpl
import com.example.kocsistemcase.data.source.MusicDataSource
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
    fun provideItunesRepository(musicDataSource: MusicDataSource): MusicRepository {
        return MusicRepositoryImpl(musicDataSource)
    }
}