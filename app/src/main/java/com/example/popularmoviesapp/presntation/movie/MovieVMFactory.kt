package com.example.popularmoviesapp.presntation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.popularmoviesapp.domain.usecase.GetMovieUseCase

class MovieVMFactory(
    private val getMovieUseCase: GetMovieUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMovieUseCase) as T
    }
}