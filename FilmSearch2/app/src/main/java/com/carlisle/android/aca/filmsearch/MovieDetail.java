package com.carlisle.android.aca.filmsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetail extends AppCompatActivity {

    Movie mMovie = new Movie();

    TextView txtTitle;
    TextView txtDescription;
    ImageView imgBackdrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

       Intent intent = getIntent();
        mMovie = (Movie) intent.getSerializableExtra("Movie");


        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtDescription = (TextView) findViewById(R.id.txtDescription);
        imgBackdrop = (ImageView) findViewById(R.id.imgBackdrop);

        txtTitle.setText(mMovie.getTitle());
        txtDescription.setText(mMovie.getDescription());
        Picasso.with(this)
                .load(mMovie.getBackdrop())
                .placeholder(R.color.colorAccent)
                .into(imgBackdrop);





    }
}
