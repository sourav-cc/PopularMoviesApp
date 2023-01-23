package com.example.popularmoviesapp.presntation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.popularmoviesapp.R
import com.example.popularmoviesapp.data.model.Movie
import com.example.popularmoviesapp.databinding.ActivityMainBinding
import com.example.popularmoviesapp.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details)
        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            val movie = bundle.getParcelable<Movie>("MOVIE")
            movie?.let { populateView(it) }
        }
    }

    private fun populateView(movie: Movie) {
        val posterURL = "https://image.tmdb.org/t/p/w500" + movie.posterPath
        Glide.with(this).load(posterURL).into(binding.movieImage)
        binding.apply{
            movieName.text = movie.title.toString()
            movieOverview.text = movie.overview.toString()
            movieRating.text = "Ratings: ${movie.vote.toString()}/10"
        }
    }
}