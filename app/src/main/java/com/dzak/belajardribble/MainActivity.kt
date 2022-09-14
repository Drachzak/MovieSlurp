package com.dzak.belajardribble

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzak.belajardribble.databinding.ActivityMainBinding
import com.dzak.belajardribble.model.MovieAppServices
import com.dzak.belajardribble.model.MovieResponse
import com.dzak.belajardribble.model.Movies
import com.dzak.belajardribble.services.MovieApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapters : Movieadaper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.rvMovieList.apply {
           layoutManager = LinearLayoutManager(this@MainActivity)
           setHasFixedSize(true)
           adapter = adapters
       }
        }
    }
    private fun getMovieData(callback: (List<Movies>) -> Unit){
    val apiServices = MovieAppServices.getInstance().create(MovieApiInterface::class.java)
        apiServices.getMovieList().enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }

        })
    }
}