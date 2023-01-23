package com.example.popularmoviesapp.data.repository.dataSourceImpl


import com.example.popularmoviesapp.BuildConfig
import com.example.popularmoviesapp.data.api.TMDBService
import com.example.popularmoviesapp.data.model.MovieList
import com.example.popularmoviesapp.data.repository.dataSource.RemoteDataSource
import retrofit2.Response

class RemoteDSourceImpl(private val tmdbService: TMDBService) : RemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(BuildConfig.API_KEY)
    }
}