package com.example.topmovie.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.topmovie.R;
import com.example.topmovie.Service.Model.Result;

import java.util.List;

public class TopMovieListAdapter extends  RecyclerView.Adapter<TopMovieListAdapter.myViewHolder>{

    private Context mContext;
    private List<Result> list;

    public TopMovieListAdapter(Context mContext, List<Result> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view =LayoutInflater.from(mContext).inflate(R.layout.movie_single,parent,false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.mTitle.setText(list.get(position).getTitle());
        holder.mReating.setText(list.get(position).getVoteAverage().toString());
        holder.mReleseDate.setText(list.get(position).getReleaseDate());
        Glide.with(mContext).load("https://image.tmdb.org/t/p/w500/"+ list.get(position).getPosterPath()).into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        if (this.list!= null){
            return list.size();

        }
        else
            return 0;


    }

    public class  myViewHolder extends RecyclerView.ViewHolder{
        ImageView  mImageView;
        TextView mTitle , mReating,mReleseDate;

         public myViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.title);
            mReating = itemView.findViewById(R.id.rating);
            mReleseDate = itemView.findViewById(R.id.releseDate);
            mImageView = itemView.findViewById(R.id.avater);


        }
    }




}
