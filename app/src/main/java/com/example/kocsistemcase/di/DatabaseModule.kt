package com.example.kocsistemcase.di

import android.app.Application
import androidx.room.Room
import com.example.kocsistemcase.data.local.MusicDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideMusicDao(app: Application): MusicDatabase {
        return Room.databaseBuilder(
            app, MusicDatabase::class.java, "music_db"
        ).build()
    }
}