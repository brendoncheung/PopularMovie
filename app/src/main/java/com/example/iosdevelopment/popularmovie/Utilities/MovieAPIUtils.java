package com.example.iosdevelopment.popularmovie.Utilities;

import android.net.Uri;

import com.example.iosdevelopment.popularmovie.POJO.Movie;

public final class MovieAPIUtils {

    public static final String KEY = "INSERT_API_KEY_HERE";

    public static final class Query {
        public static final String API_QUERY = "api_key";
    }

    public static final class BaseUrl {
        public static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/";
        public static final String MOVIE_BASE_URL = "https://api.themoviedb.org/";
    }

    public static final class Path {
        public static final String MOVIE_PATH = "3/movie";
    }

    public static class Endpoints {
        public static final String POPULAR_ENDPOINT = "popular";
        public static final String TOP_RATED_ENDPOINT = "top_rated";
    }

    public static class ImageSize {
        public static final String W92 = "w92";
        public static final String W154 = "w154";
        public static final String W185 = "w185";
        public static final String W342 = "w342";
        public static final String W500 = "w500";
        public static final String W780 = "w780";
    }

    public static Uri getImageUri(Movie movie, String imageSize) {

        Uri uri = Uri.parse(BaseUrl.IMAGE_BASE_URL).buildUpon()
                .appendEncodedPath(imageSize)
                .appendEncodedPath(movie.getPosterPath())
                .build();

        return uri;

    }

    public static Uri getMovieBackDrop(Movie movie, String imageSize) {

        Uri uri = Uri.parse(BaseUrl.IMAGE_BASE_URL).buildUpon()
                .appendEncodedPath(imageSize)
                .appendEncodedPath(movie.getBackdropPath())
                .build();

        return uri;

    }
}













