package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.movieapp.adapters.CustomFragmentPagerAdapter;
import com.example.movieapp.adapters.MovieAdapter;
import com.example.movieapp.model.Movie;
import com.example.movieapp.model.MovieResponse;
import com.example.movieapp.repositories.MovieRepository;
import com.example.movieapp.viewmodels.MovieViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Movie> movieArrayList = new ArrayList<>();
    private TextView emptyTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        emptyTextView = findViewById(R.id.empty_text_view);
        TabLayout tabLayout = findViewById(R.id.tabs);
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        // network connection check
        if (networkInfo != null && networkInfo.isConnected()){
            ViewPager viewPager =  findViewById(R.id.view_pager);
            CustomFragmentPagerAdapter adapter = new CustomFragmentPagerAdapter(getSupportFragmentManager() , 0);
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);
        }

        else {
            tabLayout.setVisibility(View.GONE);
            emptyTextView.setText("OOPS! NO INTERNET CONNECTION");
        }







    }

}
