package com.example.iosdevelopment.popularmovie.Utilities;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Date;

public class Movie {

    private int voteCount;
    private int id;
    private boolean video;
    private int voteAverage;
    private String title;
    private String poster_path;
    private String original_language;
    private String[] genreID;
    private String backdrop_path;
    private boolean adult;
    private String overview;
    private Date releaseDate;

    public Movie (JSONObject json) {

        voteCount = json.optInt("vote_count");
        id = json.optInt("id");
        video = json.optBoolean("video");
        voteAverage = json.optInt("vote_average");
        title = json.optString("title");
        poster_path = json.optString("poster_path");
        original_language = json.optString("original_language");
        genreID = toArray(json.optJSONArray("genre_ids"));
        backdrop_path = json.optString("backdrop_path");
        adult = json.optBoolean("adult");
        overview = json.optString("overview");
    }

    private String[] toArray (JSONArray array) {

        String[] str = new String[array.length()];

        for (int i =  0; i < array.length(); i++) {
            str[i] = array.optString(i);
        }

        return str;
    }

    public String getPoster_path() {

        return poster_path;
    }
}
