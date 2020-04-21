package com.example.movieapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieResponse {

    @SerializedName("results")
    private ArrayList<Movie> mResults;

    public MovieResponse(ArrayList<Movie> results){
        mResults = results;
    }

    public ArrayList<Movie> getResults() {
        return mResults;
    }

    public void setResults(ArrayList<Movie> results) {
        mResults = results;
    }
}
