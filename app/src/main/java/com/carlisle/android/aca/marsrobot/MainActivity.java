package com.carlisle.android.aca.marsrobot;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MarsRobot Freedom = new MarsRobot();
        Freedom.status = "exploring";
        Freedom.speed = 2;
        Freedom.temperature = -80;

        MarsRobot Spirit = new MarsRobot();
        Spirit.status = "exploring";
        Spirit.speed = 2;
        Spirit.temperature = -60;

        Spirit.showAttributes();
        System.out.println("Increasing speed to 3.");
        Spirit.speed = 2;
        Spirit.showAttributes();
        System.out.println("Changing temperature to -90.");
        Spirit.temperature = -90;
        Spirit.showAttributes();
        System.out.println("Checking the temperature.");
        Spirit.checkTemperature();
        Spirit.showAttributes();
        Spirit.checkBattery();

        Freedom.showAttributes();
        System.out.println("Increasing speed to 3.");
        Freedom.speed = 2;
        Freedom.showAttributes();
        System.out.println("Changing the temperature to -90.");
        Freedom.temperature = -90;
        Freedom.showAttributes();
        System.out.println("Check temperature.");
        Freedom.checkTemperature();
        Freedom.showAttributes();
        Freedom.checkBattery();



    }
}
