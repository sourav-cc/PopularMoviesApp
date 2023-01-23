package com.example.popularmoviesapp.data.repository

import android.util.Log
import com.example.popularmoviesapp.data.model.Movie
import com.example.popularmoviesapp.data.model.MovieList
import com.example.popularmoviesapp.data.repository.dataSource.RemoteDataSource
import com.example.popularmoviesapp.domain.repository.MovieRepository
import kotlinx.coroutines.delay

class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMovieFromAPI()
    }

    private suspend fun getMovieFromAPI(): List<Movie>? {
        var movieList: List<Movie>? = null
        try {
            val response = remoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.results
            }
        } catch (e: java.lang.Exception) {
            Log.d("TAG", "Some error")
        }
        return movieList
    }
}