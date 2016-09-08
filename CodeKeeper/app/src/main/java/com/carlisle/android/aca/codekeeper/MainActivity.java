package com.carlisle.android.aca.codekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    EditText mUserInput;
    TextView mResultsText;
    Button mAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    /*String[] userStrings = {"omega", "beta", "omicron"};
        CodeKeeper keeper = new CodeKeeper(userStrings);
*/

        mUserInput = (EditText) findViewById(R.id.editText);
        mResultsText = (TextView) findViewById(R.id.outputText);
        mAddButton = (Button) findViewById(R.id.button);

        final String[] userStrings = new String[10];

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userCode;

                if (mUserInput.getText().toString() != "") {
                    userCode = mUserInput.getText().toString();
                    userStrings[0] = userCode;
                }
                CodeKeeper keeper = new CodeKeeper(userStrings);
            }
        });
    }

    public class CodeKeeper {

        ArrayList list;
        String[] codes = { "alpha", "lambda", "gamma", "delta", "zeta" };

        public CodeKeeper(String[] userCodes) {
            list = new ArrayList();
            // load built-in codes
            for (int i = 0; i < codes.length; i++) {
                addCode(codes[i]);
            }

            // load user codes
            for (int j = 0; j < userCodes.length; j++) {
                addCode(userCodes[j]);
            }

            // display all the codes
            for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                String output = (String) iterator.next();
                if (output != null){
                    mResultsText.append(output + "\n");
                }

            }
        }

        private void addCode(String code) {
            if (!list.contains(code)) {issue
                list.add(code);
            }
        }
    }
}

