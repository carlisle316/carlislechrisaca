import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mFah;
    TextView mCel;
    TextView outputButton;
    Button mConvertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFah = (TextView) findViewById(R.id.fahText);
        mCel = (TextView) findViewById(R.id.celText);
        mConvertButton = (Button) findViewById(R.id.calcButton);



        mConvertButton.setOnClickListener(new View.OnClickListener() {
            String currentFah;
            String convertedTemp;
            String currentCel;

            @Override
            public void onClick(View view) {

                if (!mFah.getText().toString().equals("")) {
                    currentFah = mFah.getText().toString();
                    float fahValue = float.parseInt(currentFah);

                    fahValue = fahValue - 32;
                    fahValue = fahValue / 9;
                    fahValue = fahValue * 5;

                    convertedTemp = String.valueOf(fahValue);

                    mCel.setText(convertedTemp);
                } else if (!mCel.getText().toString().equals("")) {
                    currentCel = mCel.getText().toString();
                    int celValue = Integer.parseInt(currentCel);

                    celValue = celValue * 9;
                    celValue = celValue / 5;
                    celValue = celValue + 32;

                    convertedTemp = String.valueOf(celValue);

                    mFah.setText(convertedTemp);
                }

            }
        });


        float fah = 86;
        System.out.println(fah + " degrees Fahrenheit is ...");
        // To convert Fahrenheit to Celsius
        // begin by subtracting 32
        fah = fah - 32;
        // Divide the answer by 9
        fah = fah / 9;
        // Multiply that answer by 5
        fah = fah * 5;
        System.out.println(fah + " degrees Celsius\n");

        float cel = 33;
        System.out.println(cel + " degrees Celsius is ...");
        // To convert Celsius into Fahrenheit
        // begin by multiplying by 9
        cel = cel * 9;
        // Divide the answer by 5
        cel = cel / 5;
        // Add 32 to the answer
        cel = cel + 32;
        System.out.println(cel + " degrees Fahrenheit");




    }
}