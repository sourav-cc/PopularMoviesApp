package com.example.popularmoviesapp.domain.repository

import com.example.popularmoviesapp.data.model.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
}