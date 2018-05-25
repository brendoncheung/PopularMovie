package com.example.iosdevelopment.popularmovie.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iosdevelopment.popularmovie.POJO.Movie;
import com.example.iosdevelopment.popularmovie.R;
import com.example.iosdevelopment.popularmovie.Utilities.MovieAPIUtils;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    ImageView iv_movie_poster, iv_movie_backdrop;
    TextView tv_movieTitle, tv_release_date, tv_movie_overview, tv_movie_score;
    Movie movie;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        movie = intent.getParcelableExtra("movie");

        initialization(movie);
    }

    private void initialization(Movie movie) {
        iv_movie_poster = findViewById(R.id.iv_poster);
        iv_movie_backdrop = findViewById(R.id.iv_backdrop);

        tv_movieTitle = findViewById(R.id.tv_title);
        tv_release_date = findViewById(R.id.tv_release_date);
        tv_movie_overview = findViewById(R.id.tv_overview);
        tv_movie_score = findViewById(R.id.tv_rating);

        tv_movieTitle.setText(movie.getTitle());
        tv_release_date.setText("Release date: " + movie.getReleaseDate());
        tv_movie_overview.setText(movie.getOverview());
        tv_movie_score.setText(String.valueOf(movie.getVoteAverage()));

        Picasso.with(this)
                .load(MovieAPIUtils.getMovieBackDrop(movie, MovieAPIUtils.ImageSize.W780))
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(iv_movie_backdrop);

        Picasso.with(this)
                .load(MovieAPIUtils.getImageUri(movie, MovieAPIUtils.ImageSize.W342))
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(iv_movie_poster);

    }
}














