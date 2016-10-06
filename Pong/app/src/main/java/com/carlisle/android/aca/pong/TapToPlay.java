package com.carlisle.android.aca.pong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TapToPlay extends Activity {
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_to_play);

        mButton = (Button) findViewById(R.id.btnPlay);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TapToPlay.this, MainActivity.class);
                startActivity(i);

            }
        });
    }
}
