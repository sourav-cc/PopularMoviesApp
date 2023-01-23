package com.example.popularmoviesapp.presntation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.popularmoviesapp.R
import com.example.popularmoviesapp.data.model.Movie
import com.example.popularmoviesapp.databinding.ItemMovieBinding

class MovieListAdapter(private val onClick: (Movie) -> Unit) :
    RecyclerView.Adapter<MyViewHolder>() {
    private val movieList = ArrayList<Movie>()
    fun setList(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemMovieBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.item_movie, parent, false
        )
        return MyViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}

class MyViewHolder(val binding: ItemMovieBinding, val onClick: (Movie) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    private var currentMovie: Movie? = null

    init {
        binding.listItemLayout.setOnClickListener {
            currentMovie?.let {
                onClick(it)
            }
        }
    }

    fun bind(movie: Movie) {
        currentMovie = movie
        val posterURL = "https://image.tmdb.org/t/p/w500" + movie.posterPath
        Glide.with(binding.imageView.context).load(posterURL).into(binding.imageView)
    }

}
