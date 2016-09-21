package com.carlisle.android.aca.magicball;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button mRoll;
    TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRoll = (Button) findViewById(R.id.Roll);
        mResult = (TextView) findViewById(R.id.Result);

        mRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random randGenerator1 = new Random();
                int ourRandomNumber1 = randGenerator1.nextInt(6);
                Random randGenerator2 = new Random();
                int ourRandomNumber2 = randGenerator2.nextInt(6);

              mResult.setText("You rolled " + (ourRandomNumber1 + ourRandomNumber2 + 2));

            }
        });


        final TextView answerText = (TextView) findViewById(R.id.textView);

        final String[] anArray = new String[20];
        anArray[0] = "Yep";
        anArray[1] = "You bet";
        anArray[2] = "uh huh";
        anArray[4] = "durn tootin";
        anArray[5] = "I reckon";
        anArray[6] = "Sho nuff";
        anArray[7] = "Fo sho";
        anArray[8] = "count on it";
        anArray[9] = "Most likely";
        anArray[10] = "dunno";
        anArray[11] = "huh?";
        anArray[12] = "come again?;";
        anArray[13] = "I can't understand your accent";
        anArray[14] = "What kind of question is that?";
        anArray[15] = "nope";
        anArray[16] = "fat chance";
        anArray[17] = "Come on, man!";
        anArray[18] = "heck nah";
        anArray[19] = "Don't count on it";

        for (String s : anArray){
            Log.i("The answer is " , "" + s);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random randGenerator = new Random();
                int ourRandomNumber = randGenerator.nextInt(20);

                answerText.setText(anArray[ourRandomNumber]);

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
