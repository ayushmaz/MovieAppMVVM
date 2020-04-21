package com.example.movieapp.model;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("poster_path")
    private String mPosterPath;
    @SerializedName("release_date")
    private String mReleaseDate;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("overview")
    private String mOverview;
    public Movie(String title, String overview , String posterPath,String releaseDate){
        mTitle = title;
        mOverview = overview;
        mPosterPath = posterPath;
        mReleaseDate = releaseDate;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public String getName() {
        return mTitle;
    }

    public String getSummary() {
        return mOverview;
    }
}
