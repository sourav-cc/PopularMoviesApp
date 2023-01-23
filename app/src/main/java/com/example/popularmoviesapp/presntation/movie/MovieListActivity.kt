package com.example.popularmoviesapp.presntation.movie

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popularmoviesapp.R
import com.example.popularmoviesapp.data.model.Movie
import com.example.popularmoviesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MovieListActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MovieVMFactory
    lateinit var viewModel: MovieViewModel
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: MovieListAdapter
    private lateinit var responseLiveData: LiveData<List<Movie>?>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        responseLiveData = viewModel.getMovies()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieListAdapter { movie -> adapterOnClick(movie) }
        binding.movieRecyclerView.adapter = adapter
        displayMovies()
    }


    private fun adapterOnClick(movie: Movie) {
        val intent = Intent(this, MovieDetailsActivity()::class.java)
        intent.putExtra("MOVIE", movie)
        startActivity(intent)
    }

    private fun displayMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        responseLiveData.observe(this) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        }
    }
}