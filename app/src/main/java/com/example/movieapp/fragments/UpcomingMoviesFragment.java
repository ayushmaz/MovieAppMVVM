package com.example.movieapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.movieapp.R;
import com.example.movieapp.adapters.MovieAdapter;
import com.example.movieapp.model.Movie;
import com.example.movieapp.model.MovieResponse;
import com.example.movieapp.viewmodels.MovieViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingMoviesFragment extends Fragment {

    private ArrayList<Movie> movieArrayList = new ArrayList<>();
    private RecyclerView mRecycleView;
    private MovieAdapter mAdapter;
    private MovieViewModel movieViewModel;
    public UpcomingMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.movie_list, container, false);
        mRecycleView = rootView.findViewById(R.id.my_recycler_view);
        movieViewModel =  new ViewModelProvider(this).get(MovieViewModel.class);
        movieViewModel.init();
        movieViewModel.getUpcomingMovie().observe(this, new Observer<MovieResponse>() {
            @Override
            public void onChanged(MovieResponse movieResponse) {
                List<Movie> movieResponseResults = movieResponse.getResults();
                movieArrayList.addAll(movieResponseResults);
                mAdapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();

        return rootView;
    }

    private void initRecyclerView(){
        mAdapter = new MovieAdapter(movieArrayList , getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        mRecycleView.setLayoutManager(gridLayoutManager);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setAdapter(mAdapter);
    }
}
