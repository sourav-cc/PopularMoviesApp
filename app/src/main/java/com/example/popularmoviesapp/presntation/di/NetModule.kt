package com.example.popularmoviesapp.presntation.di

import com.example.popularmoviesapp.BuildConfig
import com.example.popularmoviesapp.data.api.TMDBService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL).build()
    }

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): TMDBService {
        return retrofit.create(TMDBService::class.java)
    }
}