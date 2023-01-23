package com.example.popularmoviesapp.presntation.di

import com.example.popularmoviesapp.domain.usecase.GetMovieUseCase
import com.example.popularmoviesapp.presntation.movie.MovieVMFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped


@Module
@InstallIn(ActivityComponent::class)
class MovieModule {
    @ActivityScoped
    @Provides
     fun provideVMFactory(
        getMovieUseCase: GetMovieUseCase
    ): MovieVMFactory {
        return MovieVMFactory(getMovieUseCase)
    }
}