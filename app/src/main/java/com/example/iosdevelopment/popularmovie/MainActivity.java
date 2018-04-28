package com.example.iosdevelopment.popularmovie;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.iosdevelopment.popularmovie.Utilities.MoiveDBNetworkUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri = MoiveDBNetworkUtils.getURL(MoiveDBNetworkUtils.TOP_RATED);

        // TODO: ask Shellee about how to do the JUnit test for getURL;
        // TODO: implement a recyclerView with Grid Manager
    }
}
