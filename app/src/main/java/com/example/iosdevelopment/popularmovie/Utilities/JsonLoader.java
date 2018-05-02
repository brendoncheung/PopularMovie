package com.example.iosdevelopment.popularmovie.Utilities;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class JsonLoader extends AsyncTaskLoader<String> {

    private Uri mUri;
    private String mCachedJson;

    public JsonLoader(Context context, Uri uri) {
        super(context);
        mUri = uri;
    }

    private String getJsonResponseFromUrl() throws IOException {

        URL url = new URL(mUri.toString());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInout = scanner.hasNext();

            if (hasInout) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        if (mCachedJson != null) {
            deliverResult(mCachedJson);
        } else {
            forceLoad();
        }
    }

    @Override
    public String loadInBackground() {

        String urlResponse = null;

        try {
            urlResponse = getJsonResponseFromUrl();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return urlResponse;
    }

    @Override
    public void deliverResult(String data) {
        mCachedJson = data;
        super.deliverResult(data);
    }
}





















