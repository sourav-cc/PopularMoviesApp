package com.example.popularmoviesapp.data.repository.dataSource

import com.example.popularmoviesapp.data.model.MovieList
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}