package com.example.iosdevelopment.popularmovie.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.iosdevelopment.popularmovie.POJO.Movie;
import com.example.iosdevelopment.popularmovie.POJO.ReturnMovie;
import com.example.iosdevelopment.popularmovie.Repository.MovieRepository;
import com.example.iosdevelopment.popularmovie.Utilities.MovieAPIUtils;

public class MainActivityMovieViewModel extends ViewModel {

    private LiveData<ReturnMovie> movie;
    private MovieRepository repo;

    public LiveData<ReturnMovie> getMovie() {
        return movie;
    }

    public MainActivityMovieViewModel() {
        repo = new MovieRepository();
       movie = repo.search(MovieAPIUtils.Endpoints.POPULAR_ENDPOINT);
    }




}














