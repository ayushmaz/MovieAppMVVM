package com.example.movieapp.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.movieapp.fragments.TopRatedMoviesFragment;
import com.example.movieapp.fragments.UpcomingMoviesFragment;

public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[] { "Top Rated" , "Upcoming" };
    public CustomFragmentPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new TopRatedMoviesFragment();
        }
        return new UpcomingMoviesFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return 2;
    }
}
