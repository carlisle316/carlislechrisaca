package com.carlisle.android.aca.comicbooks;

import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Comic[] comix = new Comic[4];

    HashMap quality = new HashMap();

    EditText mtitle;
    EditText mcondition;
    EditText missueNumber;
    EditText mbasePrice;
    TextView mValue;
    Button mcalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtitle = (EditText) findViewById(R.id.title);
        mcondition = (EditText) findViewById(R.id.condition);
        missueNumber = (EditText) findViewById(R.id.issueNumber);
        mbasePrice = (EditText) findViewById(R.id.basePrice);
        mValue = (TextView) findViewById(R.id.outputText);
        mcalculate = (Button) findViewById(R.id.calculate);

        mcalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getTitle = mtitle.getText().toString();
                String getCondition = mcondition.getText().toString();
                String getIssueNumber = missueNumber.getText().toString();
                Float getBasePrice = Float.parseFloat (mbasePrice.getText().toString());

                comix[3] = new Comic(getTitle, getCondition, getIssueNumber, getBasePrice);
                comix[3].setPrice( (Float) quality.get(comix[3].condition));

            }
        });

        HashMap quality = new HashMap();

        float price1 = 3.00F;
        quality.put("mint", price1);

        float price2 = 2.00F;
        quality.put("near mint", price2);

        float price3 = 1.50F;
        quality.put("very fine", price3);

        float price4 = 1.00F;
        quality.put("fine", price4);

        float price5 = 0.50F;
        quality.put("good", price5);

        float price6 = 0.25F;
        quality.put("poor", price6);


        // Add comics to the collection
        comix[0] = new Comic("Amazing Spider-Man", "1A", "very fine", 12_000.00F);
        comix[0].setPrice( (Float) quality.get(comix[0].condition));

        comix[1] = new Comic("The Incredible Hulk", "181", "near mint", 680.00F);
        comix[1].setPrice( (Float) quality.get(comix[1].condition));

        comix[2] = new Comic("Cerebus", "1A", "good", 190.00F);
        comix[2].setPrice( (Float) quality.get(comix[2].condition));

        for (int i = 0; i < comix.length; i++) {
            System.out.println("Title: " + comix[i].title);
            System.out.println("Issue: " + comix[i].issueNumber);
            System.out.println("Condition: " + comix[i].condition);
            System.out.println("Price: $" + comix[i].price + "\n");
        }
    }

    class Comic {
        String title;
        String issueNumber;
        String condition;
        float basePrice;
        float price;

        Comic (String inTitle, String inIssueNumber, String inCondition, float inBasePrice) {
            title = inTitle;
            issueNumber = inIssueNumber;
            condition = inCondition;
            basePrice = inBasePrice;
        }

        void setPrice(float factor) {
            price = basePrice * factor;
        }

    }

}

