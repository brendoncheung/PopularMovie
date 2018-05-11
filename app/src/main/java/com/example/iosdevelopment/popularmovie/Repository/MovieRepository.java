package com.example.iosdevelopment.popularmovie.Repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.iosdevelopment.popularmovie.Model.Movie;
import com.example.iosdevelopment.popularmovie.Services.MovieService;
import com.example.iosdevelopment.popularmovie.Utilities.MovieAPIUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieRepository {

    private static Retrofit retrofit = null;

    public static Retrofit getMovieRetrofitClient() {
        if (retrofit != null) {
            return retrofit;
        } else {
            retrofit = new Retrofit.Builder()
                    .baseUrl(MovieAPIUtils.Endpoints.POPULAR_ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit;
        }
    }

    public static LiveData<Movie> getMovie(String endpoints, String key) {

        final MutableLiveData<Movie> data = new MutableLiveData<>();

        Call<Movie> call = getMovieRetrofitClient().create(MovieService.class).requestMovie(endpoints, key);

        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {

                data.setValue(response.body());

            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

                Log.d("Tag", t.toString());
                String url = call.request().url().toString();

            }
        });

        return data;

    }
}
