package com.example.topmovie.View.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.topmovie.R;
import com.example.topmovie.Service.Model.Result;
import com.example.topmovie.View.Adapter.TopMovieListAdapter;
import com.example.topmovie.ViewModel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieListViewModel mViewModel;
    private TopMovieListAdapter movieListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleView);
        GridLayoutManager LayoutManager  = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(LayoutManager);

        mViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        mViewModel.getMovieList().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {

                movieListAdapter = new TopMovieListAdapter(MainActivity.this,results);
                recyclerView.setAdapter(movieListAdapter);

            }
        });





    }
}