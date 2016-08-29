package com.carlisle.android.aca.birthday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String birthday = new String("11/10/1978");

        System.out.print("Month :");
        System.out.println(birthday.substring(0, 2));

        System.out.print("Day :");
        System.out.println(birthday.substring(3, 5));

        System.out.print("Year :");
        System.out.println(birthday.substring(6));

        CakeStyle Vanilla = new CakeStyle();

        Vanilla.showAttributes();
        System.out.println("The vanillaq cake's height is  ");
        Vanilla.height = 80;
        Vanilla.showAttributes();
        System.out.println("The vanilla cake's weight weighs  ");
        Vanilla.weight = 50;
        Vanilla.showAttributes();
        System.out.println("The vanilla cake's depth is  ");
        Vanilla.depth = 24;





    }
}
