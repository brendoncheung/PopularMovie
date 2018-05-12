package com.example.iosdevelopment.popularmovie.Services;

import com.example.iosdevelopment.popularmovie.Utilities.MovieAPIUtils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static final String BASE_URL = MovieAPIUtils.BaseUrl.MOVIE_BASE_URL;

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();

    public static <S> S createService(Class<S> serviceClass) {


        // Use the builder object here for further customization
        // Use the httpClient to customize for logging intercepter etc

            builder.client(httpClient.build());
            retrofit = builder.build();

        return retrofit.create(serviceClass);
    }
}