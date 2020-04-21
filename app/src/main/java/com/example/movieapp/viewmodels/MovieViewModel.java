package com.example.movieapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapp.model.Movie;
import com.example.movieapp.model.MovieResponse;
import com.example.movieapp.repositories.MovieRepository;

import java.util.ArrayList;


public class MovieViewModel extends ViewModel {
    private final static String API_KEY = "80ad7e3de9139f90375664dde7f1cb2a";
    private MutableLiveData<MovieResponse> mMovie;
    private MutableLiveData<MovieResponse> mUpcomingMovie;
    private MovieRepository movieRepository;
    public void init(){
        if (mMovie != null){
            return;
        }
        movieRepository = MovieRepository.getInstance();
        mMovie = movieRepository.getMovie(API_KEY);
        mUpcomingMovie = movieRepository.getUpcomingMovie(API_KEY);
    }

    public LiveData<MovieResponse> getMovie(){
        return mMovie;
    }

    public LiveData<MovieResponse> getUpcomingMovie(){
        return mUpcomingMovie;
    }
}
