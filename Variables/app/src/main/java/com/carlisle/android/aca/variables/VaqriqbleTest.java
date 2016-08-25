package com.carlisle.android.aca.variables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VaqriqbleTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaqriqble_test);

        byte age = 37;
        short paycheck = 25976;
        int odometer = 113546;
        long jackpot = 453675121;
        float temperature = 78;
        double greaseTemperature = 346.8;
        char grade = 'A';
        boolean satisfied = true;

        System.out.println("age; " + age);
        System.out.println("paycheck; " + paycheck);
        System.out.println("odometer; " + odometer);
        System.out.println("jackpot; " + jackpot);
        System.out.println("temperature; " + temperature);
        System.out.println("greaseTemperature; " + greaseTemperature);
        System.out.println("grade; " + grade);
        System.out.println("satisfied; " + satisfied);




    }
}