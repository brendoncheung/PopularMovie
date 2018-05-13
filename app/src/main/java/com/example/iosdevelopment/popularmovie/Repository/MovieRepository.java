package com.example.iosdevelopment.popularmovie.Repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.iosdevelopment.popularmovie.POJO.Movie;
import com.example.iosdevelopment.popularmovie.POJO.ReturnMovie;
import com.example.iosdevelopment.popularmovie.Services.MovieService;
import com.example.iosdevelopment.popularmovie.Services.ServiceGenerator;
import com.example.iosdevelopment.popularmovie.Utilities.MovieAPIUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieRepository {

    private static final String TAG = MovieRepository.class.getSimpleName();

    public MutableLiveData<ReturnMovie> search(final String term) {
        final MutableLiveData<ReturnMovie> data = new MutableLiveData<>();

        MovieService service = ServiceGenerator.createService(MovieService.class);
        Call<ReturnMovie> call = service.requestMovie(term, MovieAPIUtils.KEY);

        call.enqueue(new Callback<ReturnMovie>() {
            @Override
            public void onResponse(Call<ReturnMovie> call, Response<ReturnMovie> response) {
                ReturnMovie movie = response.body();
                data.setValue(movie);
            }
            @Override
            public void onFailure(Call<ReturnMovie> call, Throwable t) {
                Log.d(TAG, t.toString());
            }
        });
        return data;
    }
}

