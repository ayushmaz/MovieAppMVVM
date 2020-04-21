package com.example.movieapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.MainActivity;
import com.example.movieapp.R;
import com.example.movieapp.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {


    private ArrayList<Movie> movie;
    private Context context;
    public MovieAdapter(ArrayList<Movie> movie , Context context){
        this.movie = movie;
        this.context = context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView movieName;
        public ImageView poster;
        public MyViewHolder(View v) {
            super(v);
            movieName = v.findViewById(R.id.movie_name);
            poster = v.findViewById(R.id.poster_img);
        }
    }

    @NonNull
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.card_list_item, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyViewHolder holder, int position) {
        final Movie myMedia = movie.get(position);
        holder.movieName.setText(myMedia.getName());
        String imageURL = "https://image.tmdb.org/t/p/w342//" + myMedia.getPosterPath();
        Glide.with(context)
                .load(imageURL)
                .into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return movie.size();
    }
}
