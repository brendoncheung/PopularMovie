package com.example.iosdevelopment.popularmovie.Services;

import com.example.iosdevelopment.popularmovie.Utilities.MovieAPIUtils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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

    private static HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    public static <S> S createService(Class<S> serviceClass) {


        // Use the builder object here for further customization
        // Use the httpClient to customize for logging intercepter etc
        if (!httpClient.interceptors().contains(httpLoggingInterceptor)) {
            httpClient.addInterceptor(httpLoggingInterceptor);
            builder.client(httpClient.build());
            retrofit = builder.build();
        }

        return retrofit.create(serviceClass);
    }

}
