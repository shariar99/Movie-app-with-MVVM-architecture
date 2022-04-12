package com.example.topmovie.Service.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static String BASEURL =  "https://api.themoviedb.org/";
    private static Retrofit retrofit ;
    public static Retrofit getRetroInstance(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create())
                    .build();


        }
        return retrofit;
    }
}
