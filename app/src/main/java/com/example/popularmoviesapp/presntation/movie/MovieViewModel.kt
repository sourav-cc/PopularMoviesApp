package com.example.popularmoviesapp.presntation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.popularmoviesapp.domain.usecase.GetMovieUseCase

class MovieViewModel(
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {


    fun getMovies() = liveData {
        val movieList = getMovieUseCase.getMovies()
        emit(movieList)
    }

}