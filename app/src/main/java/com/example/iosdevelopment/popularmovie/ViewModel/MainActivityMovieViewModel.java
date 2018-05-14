package com.example.iosdevelopment.popularmovie.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.iosdevelopment.popularmovie.POJO.Movie;
import com.example.iosdevelopment.popularmovie.POJO.ReturnMovie;
import com.example.iosdevelopment.popularmovie.Repository.MovieRepository;
import com.example.iosdevelopment.popularmovie.Services.MovieService;
import com.example.iosdevelopment.popularmovie.Services.ServiceGenerator;
import com.example.iosdevelopment.popularmovie.Utilities.MovieAPIUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityMovieViewModel extends ViewModel {

    private static final String TAG = MainActivityMovieViewModel.class.getSimpleName();

    private MutableLiveData<ReturnMovie> movie;
    private MovieRepository repo = new MovieRepository();
    private String search = null;

    public MutableLiveData<ReturnMovie> getMovie() {

        if (movie == null) {
            movie = new MutableLiveData<>();
        }
        return movie;
    }

    public void loadMovie(String searchTerm) {

        MovieService service = ServiceGenerator.createService(MovieService.class);
        Call<ReturnMovie> call = service.requestMovie(searchTerm, MovieAPIUtils.KEY);

        call.enqueue(new Callback<ReturnMovie>() {
            @Override
            public void onResponse(Call<ReturnMovie> call, Response<ReturnMovie> response) {
                movie.setValue(response.body());
            }
            @Override
            public void onFailure(Call<ReturnMovie> call, Throwable t) {
                Log.d(TAG, t.toString());
            }
        });
    }
}














