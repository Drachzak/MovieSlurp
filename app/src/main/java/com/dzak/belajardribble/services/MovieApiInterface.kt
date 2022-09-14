package com.dzak.belajardribble.services

import com.dzak.belajardribble.model.MovieResponse
import com.dzak.belajardribble.model.Movies
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET("/3/movie/popular?api_key=1856d2da1ead2f1dc83c9dd8543d3253")
    fun getMovieList(): Call<MovieResponse>
}