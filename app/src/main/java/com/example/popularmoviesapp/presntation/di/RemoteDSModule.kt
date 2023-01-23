package com.example.popularmoviesapp.presntation.di

import com.example.popularmoviesapp.data.api.TMDBService
import com.example.popularmoviesapp.data.repository.dataSource.RemoteDataSource
import com.example.popularmoviesapp.data.repository.dataSourceImpl.RemoteDSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RemoteDSModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(tmdbService: TMDBService): RemoteDataSource {
        return RemoteDSourceImpl(tmdbService)
    }
}