package org.hello.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //assign variables
    Button button;
    EditText billAmount, tipRate;
    TextView tipResult, totalResult;

    double billA,
            tipR,
            result, tResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //obtain references to components defined within Activity layout file
        billAmount = findViewById(R.id.billText);
        tipRate = findViewById(R.id.tipText);
        button = findViewById(R.id.convertButton);
        tipResult = findViewById(R.id.tipResult);
        totalResult=findViewById(R.id.totalAmount);

        //button click initiated with a function to do the following method
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //assign references to the corresponding double variables
                if(billAmount !=null && billAmount.length()>=1){
                    billA = Double.parseDouble(billAmount.getText().toString());
                }

                if(tipRate !=null && tipRate.length()>=1){
                    tipR = Double.parseDouble(tipRate.getText().toString());
                }

                //calculation of tip Amount and total Bill Amount
                result = (billA)* (tipR/100.0);
                tResult = billA + result;

                Toast.makeText(getApplicationContext(), "Calculating Tips and Total Bill Amount!", Toast.LENGTH_SHORT).show();

                //Display output
                tipResult.setText(Double.toString(result));
                tipResult.setText(String.format("%1.2f", result));

                totalResult.setText(Double.toString(tResult));
                totalResult.setText(String.format("%1.2f", tResult));



            }
        });

    }
}
