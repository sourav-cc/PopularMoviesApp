package com.example.popularmoviesapp.presntation.di

import com.example.popularmoviesapp.data.repository.MovieRepositoryImpl
import com.example.popularmoviesapp.data.repository.dataSource.RemoteDataSource
import com.example.popularmoviesapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: RemoteDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(remoteDataSource)
    }
}