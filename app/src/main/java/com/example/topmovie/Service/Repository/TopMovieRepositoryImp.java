package com.example.topmovie.Service.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.topmovie.Service.Model.Result;

import java.util.List;

public interface TopMovieRepositoryImp {
    public MutableLiveData<List<Result>> getMovieList();
}
