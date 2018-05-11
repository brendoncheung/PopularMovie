package com.example.iosdevelopment.popularmovie.Utilities;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.iosdevelopment.popularmovie.Model.Movie;
import com.example.iosdevelopment.popularmovie.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Viewholder>{

    private List<Movie> movieList;
    private Context mContext;
    final private MovieOnClickListener movieOnClickListener;

    public MovieAdapter (Context context, MovieOnClickListener listener) {
        mContext = context;
        movieOnClickListener = listener;
    }

    public interface MovieOnClickListener {
        void onMovieClick(int position);
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

        Uri uri = new Uri.Builder()
                .authority(MovieAPIUtils.BaseUrl.IMAGE_BASE_URL)
                .appendPath(MovieAPIUtils.ImageSize.W185)
                .appendPath(movieList.get(position).getPoster_path())
                .build();

        Picasso.with(mContext)
                .load(uri)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.moviePoster);
    }

    @Override
    public int getItemCount() {

        if (movieList == null) {
            return 0;
        } else {

        } return movieList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView moviePoster;

        public Viewholder(View itemView) {
            super(itemView);

            moviePoster = itemView.findViewById(R.id.movie_poster_iv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    movieOnClickListener.onMovieClick(getAdapterPosition());
                }
            });
        }

    }

    // TODO: Construct a setMovieData function and notify change i.e. notifyDataSetChanged(). Read documentation for clarity.

    public void swapCursor(List<Movie> movies) {
        movieList = movies;
        notifyDataSetChanged();
    }
}






















