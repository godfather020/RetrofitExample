package com.example.retrofitexample.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.retrofitexample.R;
import com.example.retrofitexample.model.MovieModel;

import java.util.List;
import java.util.Locale;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private Context context;
    private List<MovieModel> movieList;

    public MovieAdapter(Context context, List<MovieModel> movieList) {

        this.context =context;
        this.movieList = movieList;
    }

    public void setMovieList(List<MovieModel> movieList){

        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycle_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyViewHolder movieAdapter, int position) {

        movieAdapter.movie_txt.setText(this.movieList.get(position).getTitle().toString());
        Glide.with(context)
                .load(this.movieList.get(position).getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(movieAdapter.img_movie);

    }

    @Override
    public int getItemCount() {

        if (this.movieList != null){
            return this.movieList.size();
        }
        return 0;
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        ImageView img_movie;
        TextView movie_txt;
        public MyViewHolder(View view){
            super(view);
            img_movie = view.findViewById(R.id.img_noti);
            movie_txt = view.findViewById(R.id.txt_title);
        }
    }
}
