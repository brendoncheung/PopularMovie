package com.example.iosdevelopment.popularmovie.Utilities;

import android.net.Uri;

public final class MoiveDBNetworkUtils {

    private static final String KEY = "6fffa22d1ba58423a952b48709479f7d";
    private static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/";
    private static final String MOVIE_BASE_URL = "https://api.themoviedb.org/3/";

    private static final String MOVIE_PARAM = "movie";
    private static final String POPULAR_PARAM = "popular";
    private static final String TOP_RATED_PARAM = "top_rated";

    public static final String POPULAR = POPULAR_PARAM;
    public static final String TOP_RATED = TOP_RATED_PARAM;

    private static final String API_QUERY = "api_key";



    public static Uri getURL (String category) {

        Uri.Builder builder = Uri.parse(MOVIE_BASE_URL).buildUpon();

        builder.appendPath(MOVIE_PARAM)
        .appendPath(category)
        .appendQueryParameter(API_QUERY, KEY);

        return builder.build();

    }

    public static void getImage() {

    }




}
