package com.example.iosdevelopment.popularmovie.Services;

import com.example.iosdevelopment.popularmovie.Model.Movie;
import com.example.iosdevelopment.popularmovie.Utilities.MovieAPIUtils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {

    @GET(MovieAPIUtils.Path.MOVIE_PATH + "/{param}")
    Call<Movie> requestMovie (@Path("param") String endpoints,
                              @Query(MovieAPIUtils.Query.API_QUERY) String key);

}
