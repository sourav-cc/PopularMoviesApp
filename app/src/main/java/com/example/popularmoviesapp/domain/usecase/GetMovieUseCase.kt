package com.example.popularmoviesapp.domain.usecase

import com.example.popularmoviesapp.data.model.Movie
import com.example.popularmoviesapp.domain.repository.MovieRepository

class GetMovieUseCase(private val movieRepository: MovieRepository) {
    suspend fun getMovies(): List<Movie>? = movieRepository.getMovies()
}