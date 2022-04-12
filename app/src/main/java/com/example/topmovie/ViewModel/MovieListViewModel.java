package com.example.topmovie.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.topmovie.Service.Model.Result;
import com.example.topmovie.Service.Repository.TopMovieRepository;
import com.example.topmovie.Service.Repository.TopMovieRepositoryImp;

import java.util.List;

public class MovieListViewModel extends AndroidViewModel {

    private TopMovieRepositoryImp mrepo;


    public MovieListViewModel(@NonNull Application application) {
        super(application);

        mrepo = TopMovieRepository.getInstance(application);


    }

    public LiveData<List<Result>> getMovieList(){

        return  mrepo.getMovieList();
    }

}
