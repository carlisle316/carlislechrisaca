package com.carlisle.android.aca.marsrobot;

/**
 * Created by chriscarlisle on 8/24/16.
 */
public class MarsRobot {
    String status;
    int speed;
    int battery;
    float visibility;
    float temperature;

    void checkTemperature() {
        if (temperature < -80) {
            status = "returning home";
            speed = 5;
        }

    }

    void showAttributes() {
        System.out.println("status; " + status);
        System.out.println("speed; " + speed);
        System.out.println("temperature; " + temperature);
        System.out.println("battery; " + battery);
        System.out.println("visibility; " + visibility);

    }

    void checkBattery() {
        if (battery < 20) {
            status = "returning home";
            speed = 5;
        }
    }
}