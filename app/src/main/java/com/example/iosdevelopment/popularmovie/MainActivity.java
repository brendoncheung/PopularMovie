package com.example.iosdevelopment.popularmovie;

import android.app.LoaderManager;
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
        initRecyclerViewWithMovies();

        getLoaderManager().initLoader(JSONLOADER_ID, null, this);

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
                Toast.makeText(this, "Top rated selected", Toast.LENGTH_SHORT).show();
                bundle.putString("option", MovieDBUriUtils.TOP_RATED);
                getLoaderManager().restartLoader(JSONLOADER_ID, bundle, this);
                return true;

            case R.id.most_popular_menu:
                Toast.makeText(this, "Popular selected", Toast.LENGTH_SHORT).show();
                bundle.putString("option", MovieDBUriUtils.POPULAR);
                getLoaderManager().restartLoader(JSONLOADER_ID, bundle, this);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public Loader<String> onCreateLoader(int id, final Bundle args) {
        return new JsonLoader(this, MovieDBUriUtils.buildUri(MovieDBUriUtils.POPULAR));
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {

        movies = new ArrayList<Movie>();

        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonResults = jsonObject.getJSONArray("results");

            for (int i = 0; i < jsonResults.length(); i++) {
                movies.add(new Movie(jsonResults.optJSONObject(i)));
                Log.d("Main Activity", MovieDBUriUtils.buildImageUriFromMovie(movies.get(i), MovieDBUriUtils.W185).toString());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // TODO: Change the below function signature to accept movie arraylist

        mMovieAdapter.swapCursor(movies);


    }

    @Override
    public void onLoaderReset(Loader<String> loader) {
        mMovieAdapter.swapCursor(null);

    }



    private void initRecyclerViewWithMovies() {
        mRecyclerView = findViewById(R.id.movie_rc);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.hasFixedSize();

        mMovieAdapter = new MovieAdapter(this);
        mRecyclerView.setAdapter(mMovieAdapter);
        mRecyclerView.setBackgroundColor(getResources().getColor(R.color.cardview_dark_background));

    }




}
