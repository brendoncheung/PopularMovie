package com.example.iosdevelopment.popularmovie.Activity;

import android.app.LoaderManager;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.iosdevelopment.popularmovie.R;
import com.example.iosdevelopment.popularmovie.Services.MovieService;
import com.example.iosdevelopment.popularmovie.Utilities.JsonLoader;
import com.example.iosdevelopment.popularmovie.Utilities.MovieAdapter;
import com.example.iosdevelopment.popularmovie.Utilities.MovieAPIUtils;
import com.example.iosdevelopment.popularmovie.Model.Movie;
import com.example.iosdevelopment.popularmovie.ViewModel.MainActivityMovieViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MovieAdapter.MovieOnClickListener {

    private RecyclerView mRecyclerView;
    private MovieAdapter mMovieAdapter;
    private MainActivityMovieViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainActivityMovieViewModel.class);
        initRecyclerViewWithMovies();

        Movie movie = viewModel.getMovie(MovieAPIUtils.Endpoints.POPULAR_ENDPOINT, MovieAPIUtils.KEY).getValue();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.movie_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Bundle bundle = new Bundle();

        switch (item.getItemId()) {

            case R.id.top_rated_menu:
                bundle.putString("option", MovieAPIUtils.Endpoints.TOP_RATED_ENDPOINT);
                return true;

            case R.id.most_popular_menu:
                bundle.putString("option", MovieAPIUtils.Endpoints.POPULAR_ENDPOINT);
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
    public void onMovieClick(int position) {

        // TODO: Implement detail view
    }
}









