package com.example.iosdevelopment.popularmovie.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.iosdevelopment.popularmovie.Model.Movie;
import com.example.iosdevelopment.popularmovie.R;
import com.example.iosdevelopment.popularmovie.Utilities.MovieAPIUtils;
import com.squareup.picasso.Picasso;

// TODO: implement a coordinator view

public class DetailActivity extends AppCompatActivity {

    ImageView mMoviePoster;
    Movie movie;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        movie = intent.getParcelableExtra("movie");

        mMoviePoster = findViewById(R.id.detail_movie_poster_iv);

//        Picasso.with(this)
//                .load(MovieAPIUtils.buildImageUriFromMovie(movie, MovieAPIUtils.W780))
//                .placeholder(R.drawable.ic_launcher_background)
//                .error(R.drawable.ic_launcher_background)
//                .into(mMoviePoster);
    }
}
