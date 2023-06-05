package com.example.kocsistemcase.di

import com.example.kocsistemcase.domain.repository.MusicRepository
import com.example.kocsistemcase.domain.usecase.GetMusicListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideMusicUseCase(musicRepository: MusicRepository): GetMusicListUseCase {
        return GetMusicListUseCase(musicRepository)
    }
}