package com.carlisle.android.aca.filmsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetail extends AppCompatActivity {

    TextView txtTitle = (TextView) findViewById(R.id.txtTitle);
    TextView txtDescription = (TextView) findViewById(R.id.txtDescription);
    ImageView imgBackground = (ImageView) findViewById(R.id.imgBackdrop);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Intent intent = getIntent();
        RecyclerView mRecyclerView = (RecyclerView) intent.getSerializableExtra(Movie);
    }
}
