package com.example.iosdevelopment.popularmovie.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.iosdevelopment.popularmovie.Model.Movie;
import com.example.iosdevelopment.popularmovie.Repository.MovieRepository;
import com.example.iosdevelopment.popularmovie.Utilities.MovieAPIUtils;

public class MainActivityMovieViewModel extends ViewModel {

    private LiveData<Movie> popular;
    private LiveData<Movie> topRated;
    private MovieRepository movieRepository;

    public LiveData<Movie> getMovie(String endpoints, String key) {
        return movieRepository.getMovie(endpoints, key);
    }

    public MainActivityMovieViewModel(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
}














