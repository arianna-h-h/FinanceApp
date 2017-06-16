package com.example.ariannaharadon.financeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.icu.text.DecimalFormatSymbols;
import android.icu.text.DecimalFormat;


public class InterestActivity extends AppCompatActivity {
    double cost;
    double term;
    double rate;
    EditText etRate;
    EditText etTerm;
    EditText etCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        etRate=(EditText)findViewById(R.id.rate);

        etTerm=(EditText)findViewById(R.id.term);

        etCost=(EditText)findViewById(R.id.cost);



        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
                @Override
    public void onClick(View v) {
                    rate= Double.parseDouble(etRate.getText().toString());
                    term= Double.parseDouble(etTerm.getText().toString());
                    cost= Double.parseDouble(etCost.getText().toString());
                    double finRate = rate/100;
                    double priceWithInterest = cost* (Math.pow((1.0 + finRate/12.0), (term)));


                    DecimalFormatSymbols symbols = new DecimalFormatSymbols();
                    symbols.setGroupingSeparator('\'');
                    symbols.setDecimalSeparator('.');

                    DecimalFormat decimalFormat = new DecimalFormat("$#,###.##", symbols);
                    String priceWithInterestForm = decimalFormat.format(priceWithInterest);
                    TextView price = (TextView) findViewById(R.id.textViewResults);
                    price.setText("The price with interest is " + priceWithInterestForm);
                    String interestForm = decimalFormat.format(priceWithInterest-cost);
                    TextView interest = (TextView) findViewById(R.id.textViewCostResults);
                    interest.setText("You are paying " + interestForm + " in interest");

    }
});


            }

        }


