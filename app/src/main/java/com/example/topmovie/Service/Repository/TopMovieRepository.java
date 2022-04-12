package com.example.topmovie.Service.Repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.topmovie.Service.Model.MovieModel;
import com.example.topmovie.Service.Model.Result;
import com.example.topmovie.Service.Network.ApiServices;
import com.example.topmovie.Service.Network.RetrofitInstance;

import java.lang.invoke.MutableCallSite;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopMovieRepository implements TopMovieRepositoryImp {

    private static Context mcontext;
    private  MovieModel  movieModel;
    private List<Result > mResult;
    private MutableLiveData mLivedata;

    private  static TopMovieRepository instance;

    public static  TopMovieRepository getInstance( Context context)

    {
        if (instance == null){
           mcontext = context;
            instance = new TopMovieRepository();
        }
        return instance;

    }
    @Override
    public MutableLiveData <List<Result>> getMovieList(){
        if (mLivedata==null){
            mLivedata = new MutableLiveData();
        }



        ApiServices apiServices = RetrofitInstance.getRetroInstance().create(ApiServices.class);
       Call <MovieModel> call= apiServices.getTopRetedMovieList();
       call.enqueue(new Callback<MovieModel>() {
           @Override
           public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {

               movieModel= response.body();
              mResult=movieModel.getResults();
               mLivedata.postValue(mResult);

           }

           @Override
           public void onFailure(Call<MovieModel> call, Throwable t) {

           }
       });
       return mLivedata;
    }

}
