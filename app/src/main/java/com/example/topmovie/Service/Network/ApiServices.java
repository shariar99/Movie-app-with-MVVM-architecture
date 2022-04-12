package com.example.topmovie.Service.Network;

import com.example.topmovie.Service.Model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("3/movie/top_rated?api_key=950414a5c4a3e26c0b2a962c8c65bad1&language=en-US&page=1")
    Call<MovieModel> getTopRetedMovieList();


}
