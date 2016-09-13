package com.carlisle.android.aca.accessscopethisandstatic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fighter aFighter = new Fighter();
        Bomber aBomber = new Bomber();

// Can't do this AlienShip is abstract -
// Literally speaking as well as in code
// AlienShip alienShip = new AlienShip(500);

// But our objects of the subclasses can still do
// everything the AlienShip is meant to do

        aBomber.shipName = "Newell Bomber";
        aFighter.shipName = "Meier Fighter";
// And because of the overridden constructor
// That still calls the super constructor
// They have unique properties
        Log.i("aFighter Shield:", ""+ aFighter.getShieldStrength());
        Log.i("aBomber Shield:", ""+ aBomber.getShieldStrength());

// As well as certain things in certain ways
// That are unique to the subclass
        aBomber.fireWeapon();
        aFighter.fireWeapon();

// Take down those alien ships
// Focus on the bomber it has a weaker shield
        aBomber.hitDetected();
        aBomber.hitDetected();
        aBomber.hitDetected();
        aBomber.hitDetected();



        AlienShip girlShip = new AlienShip();
        AlienShip boyship = new AlienShip();

        Log.i("numShips; ", '' + AlienShip.getNumships());

        girlShip.shipName = "Connie Yu";
        boyship.shipName = "Andre LaMothe";

        Log.i("girlShip shieldStrength; ", "" + girlShip.getShieldStrengt());
        Log.i("boyShip shieldStrength; ", "" + boyship.getShieldStrength());

        girlShip.hitDetected();
        Log.i("girlShip shieldStrength; ", "" + girlShip.getShieldStrengt());
        Log.i("boyship shieldStrength; ", "" + boyship.getShieldStrength());

        boyship hitDetected();
        boyship hitDetected();
        boyship hitDetected();

        Log.i("girlship shieldSStrength; ", "" + girlShip.getShieldStrengt());

        Log.i("boyShip shieldStrength; ", "" + boyship.getShieldStrength());

        boyship hitDetected();
        Log.i("girlShip shieldStrength; ", "" + girlShip.getShieldStrengt());
        Log.i("boyship shieldStrength; ", "" + boyship.getShieldStrength());

        Log.i("numShips; ", "" + AlienShip.getNumships());


    }
}
