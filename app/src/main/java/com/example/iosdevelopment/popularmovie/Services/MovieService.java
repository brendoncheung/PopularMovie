package com.example.iosdevelopment.popularmovie.Services;

import com.example.iosdevelopment.popularmovie.POJO.Movie;
import com.example.iosdevelopment.popularmovie.POJO.ReturnMovie;
import com.example.iosdevelopment.popularmovie.Utilities.MovieAPIUtils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {

    @GET(MovieAPIUtils.Path.MOVIE_PATH + "/{param}")
    Call<ReturnMovie> requestMovie (@Path("param") String endpoints,
                                    @Query(MovieAPIUtils.Query.API_QUERY) String key);

}
