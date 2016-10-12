package com.carlisle.android.aca.holidayschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.BitSet;

public class MainActivity extends AppCompatActivity {
    Button mButton;
    TextView mTextView;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.editText);
        mTextView = (TextView) findViewById(R.id.txtAnswer);
        mButton = (Button) findViewById(R.id.btnCheck);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        HolidaySchedule cal = new HolidaySchedule();
        String day = 2;

        if (!day.equals("")) {
            try {
                int whichDay = Integer.parseInt(day);
                if (cal.isHoliday(whichDay)) {
                    System.out.println("Day number " + whichDay +
                            " is a holiday.");
                } else {
                    System.out.println("Day number " + whichDay + " is not a holiday");

                }catch (NumberFormatException nfe) {
                    System.out.println("Error; " + nfe.getMessage());
                }
            }
        }
    }

    public class HolidaySchedule {
        BitSet sked;

        public HolidaySchedule() {
            sked = new BitSet(365);
            int[] holiday = {1, 15, 50, 148, 185, 246, 281, 316, 326, 359};
            for (int i = 0; i < holiday.length; i++){
                addHoliday(holiday(i));
            }
        }
        public void addHoliday(int dayToAdd) {
            sked.set(dayToAdd);

        }
        public boolean isHoliday (int dayToCheck) {
            return sked.get(dayToCheck);

        }
    }
}
