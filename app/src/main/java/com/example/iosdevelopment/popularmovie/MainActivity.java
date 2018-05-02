package com.example.iosdevelopment.popularmovie;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.iosdevelopment.popularmovie.Utilities.JsonLoader;
import com.example.iosdevelopment.popularmovie.Utilities.MovieAdapter;
import com.example.iosdevelopment.popularmovie.Utilities.MovieDBUriUtils;
import com.example.iosdevelopment.popularmovie.Utilities.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private static final int JSONLOADER_ID = 111;
    private List<Movie> movies;
    private RecyclerView mRecyclerView;
    private MovieAdapter mMovieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLoaderManager().initLoader(JSONLOADER_ID, null, this);

    }

    @Override
    public Loader<String> onCreateLoader(int id, final Bundle args) {
        return new JsonLoader(this, MovieDBUriUtils.buildUri(MovieDBUriUtils.POPULAR));
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {

        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonResults = jsonObject.getJSONArray("results");

            movies = new ArrayList<Movie>();

            for (int i = 0; i < jsonResults.length(); i++) {
                movies.add(new Movie(jsonResults.optJSONObject(i)));
                Log.d("Main Activity", MovieDBUriUtils.buildImageUri(movies.get(i), MovieDBUriUtils.W185).toString());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        initView();

    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }



    private void initView() {

        mRecyclerView = findViewById(R.id.movie_rc);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.hasFixedSize();

        mMovieAdapter = new MovieAdapter(this,movies);
        mRecyclerView.setAdapter(mMovieAdapter);
        mRecyclerView.setBackgroundColor(getResources().getColor(R.color.cardview_dark_background));

    }




}
