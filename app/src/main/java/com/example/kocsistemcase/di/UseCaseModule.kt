package com.example.kocsistemcase.di

import com.example.kocsistemcase.domain.repository.MusicRepository
import com.example.kocsistemcase.domain.usecase.*
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
    @Provides
    @Singleton
    fun provideGridTrackListUseCase(musicRepository: MusicRepository): GridTrackListMusicUseCase {
        return GridTrackListMusicUseCase(musicRepository)
    }
    @Provides
    @Singleton
    fun provideTrackListUseCase(musicRepository: MusicRepository): TrackListMusicUseCase {
        return TrackListMusicUseCase(musicRepository)
    }
    @Provides
    @Singleton
    fun providePriceUseCase(musicRepository: MusicRepository): PriceListUseCase {
        return PriceListUseCase(musicRepository)
    }

}