package com.example.iosdevelopment.popularmovie.Utilities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.iosdevelopment.popularmovie.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Viewholder>{

    List<Movie> movieList;
    Context mContext;

    public MovieAdapter (Context context, List<Movie> movies) {
        mContext = context;
        movieList = movies;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.movie_item, parent, false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        Picasso.with(mContext)
                .load(MovieDBUriUtils.buildImageUri(movieList.get(position), MovieDBUriUtils.W185))
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.moviePoster);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {

        ImageView moviePoster;

        public Viewholder(View itemView) {
            super(itemView);

            moviePoster = itemView.findViewById(R.id.movie_poster_iv);
        }
    }
}
