package com.example.iosdevelopment.popularmovie.Utilities;

import android.net.Uri;

public final class MovieDBUriUtils {

    private static final String KEY = "6fffa22d1ba58423a952b48709479f7d";
    private static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/";
    private static final String MOVIE_BASE_URL = "https://api.themoviedb.org/3";

    private static final String MOVIE_PARAM = "movie";
    private static final String POPULAR_PARAM = "popular";
    private static final String TOP_RATED_PARAM = "top_rated";

    private static final String W92_PARAM = "w92";
    private static final String W154_PARAM = "w154";
    private static final String W185_PARAM = "w185";
    private static final String W342_PARAM = "w342";
    private static final String W500_PARAM = "w500";
    private static final String W780_PARAM = "w780";

    public static final String W92 = W92_PARAM;
    public static final String W154 = W154_PARAM;
    public static final String W185 = W185_PARAM;
    public static final String W342 = W342_PARAM;
    public static final String W500 = W500_PARAM;
    public static final String W780 = W780_PARAM;

    public static final String POPULAR = POPULAR_PARAM;
    public static final String TOP_RATED = TOP_RATED_PARAM;

    private static final String API_QUERY = "api_key";

    public static Uri buildUri(String category) {

        Uri uri = Uri.parse(MOVIE_BASE_URL);

        Uri.Builder builder = uri.buildUpon();

        builder.appendPath(MOVIE_PARAM)
        .appendPath(category)
        .appendQueryParameter(API_QUERY, KEY);

        return builder.build();

    }

    public static Uri buildImageUriFromMovie(Movie movie, String size) {

        Uri.Builder builder = Uri.parse(IMAGE_BASE_URL).buildUpon()
                .appendPath(size)
                .appendEncodedPath(movie.getPoster_path());

        return builder.build();
    }



}
