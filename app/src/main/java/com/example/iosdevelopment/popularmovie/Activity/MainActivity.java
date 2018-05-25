package com.example.iosdevelopment.popularmovie.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.iosdevelopment.popularmovie.POJO.ReturnMovie;
import com.example.iosdevelopment.popularmovie.R;
import com.example.iosdevelopment.popularmovie.Repository.MovieRepository;
import com.example.iosdevelopment.popularmovie.Utilities.MovieAdapter;
import com.example.iosdevelopment.popularmovie.Utilities.MovieAPIUtils;
import com.example.iosdevelopment.popularmovie.POJO.Movie;
import com.example.iosdevelopment.popularmovie.ViewModel.MainActivityMovieViewModel;

public class MainActivity extends AppCompatActivity implements MovieAdapter.MovieOnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private MovieAdapter mMovieAdapter;
    private MainActivityMovieViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainActivityMovieViewModel.class);
        initRecyclerViewWithMovies();

        viewModel.loadMovie(MovieAPIUtils.Endpoints.TOP_RATED_ENDPOINT);

        viewModel.getMovie().observe(this, new Observer<ReturnMovie>() {
            @Override
            public void onChanged(@Nullable ReturnMovie returnMovie) {
                mMovieAdapter.swapCursor(returnMovie.getResults());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.movie_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.top_rated_menu:
                viewModel.loadMovie(MovieAPIUtils.Endpoints.TOP_RATED_ENDPOINT);
                return true;

            case R.id.most_popular_menu:
                viewModel.loadMovie(MovieAPIUtils.Endpoints.POPULAR_ENDPOINT);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initRecyclerViewWithMovies() {
        mRecyclerView = findViewById(R.id.movie_rc);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.hasFixedSize();

        mMovieAdapter = new MovieAdapter(this, this);
        mRecyclerView.setAdapter(mMovieAdapter);
        mRecyclerView.setBackgroundColor(getResources().getColor(R.color.cardview_dark_background));
    }

    @Override
    public void onMovieClick(Movie movie) {
        Intent intent = new Intent(this, DetailActivity.class);

        intent.putExtra("movie", movie);
        startActivity(intent);
    }
}














