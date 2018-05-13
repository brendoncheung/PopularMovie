package com.example.iosdevelopment.popularmovie.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.iosdevelopment.popularmovie.POJO.Movie;
import com.example.iosdevelopment.popularmovie.POJO.ReturnMovie;
import com.example.iosdevelopment.popularmovie.Repository.MovieRepository;
import com.example.iosdevelopment.popularmovie.Utilities.MovieAPIUtils;

public class MainActivityMovieViewModel extends ViewModel {

    private static final String TAG = MainActivityMovieViewModel.class.getSimpleName();

    private MutableLiveData<ReturnMovie> movie;
    private MovieRepository repo = new MovieRepository();
    private String search = null;

    public LiveData<ReturnMovie> getMovie(String searchTerm) {

//        if (movie == null && searchTerm != search) {
//            movie = repo.search(searchTerm);
//            search = searchTerm;
//        }

        movie = repo.search(searchTerm);

        return movie;
    }
}














