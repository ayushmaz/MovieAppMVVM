package com.example.movieapp.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.movieapp.MainActivity;
import com.example.movieapp.model.Movie;
import com.example.movieapp.model.MovieResponse;
import com.example.movieapp.network.MovieEndpoints;
import com.example.movieapp.network.RetrofitClientInstance;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static MovieRepository instance;
    private ArrayList<Movie> movieArrayList;
    private MovieEndpoints service;


    public MovieRepository(){
        service = RetrofitClientInstance.getRetrofitInstance().create(MovieEndpoints.class);
    }

    public static MovieRepository getInstance() {

        if(instance == null){
            instance = new MovieRepository();
        }
        return instance;
    }



    public MutableLiveData<MovieResponse> getMovie(String key) {

        final MutableLiveData<MovieResponse> data = new MutableLiveData<>();
        service.getTopRatedMovies(key).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()){
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG , "Error: " + t.toString());
                //data.setValue(null);
            }
        });

        return data;
    }

    public MutableLiveData<MovieResponse> getUpcomingMovie(String key) {

        final MutableLiveData<MovieResponse> data = new MutableLiveData<>();
        service.getUpcomingMovies(key).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()){
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                //data.setValue(null);
            }
        });

        return data;
    }
}
