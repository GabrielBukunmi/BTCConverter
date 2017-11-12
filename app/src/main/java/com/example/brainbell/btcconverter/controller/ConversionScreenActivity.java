package com.example.brainbell.btcconverter.controller;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brainbell.btcconverter.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;


public class ConversionScreenActivity extends AppCompatActivity {
    TextView baseCurrency;
    EditText editText;
    TextView resultText;
    String spinner1text;
    String spinner2text;
    double rate;
    double result;
    double userinput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_screen);

        spinner1text=getIntent().getExtras().getString("spinner1text");
        editText = (EditText) findViewById(R.id.editText);
        resultText = (TextView) findViewById(R.id.result_text);
        rate = getIntent().getExtras().getDouble("rate");
         baseCurrency=(TextView)findViewById(R.id.baseCurrency);
        baseCurrency.setText(spinner1text);
        spinner2text=getIntent().getExtras().getString("spinner2text");
        getSupportActionBar().setTitle( spinner1text + "------" + spinner2text);

    }

    public void Convert(View view) {
        String userInput = editText.getText().toString();

        if(rate==0){
            resultText.setVisibility(View.GONE);
            Toast.makeText(this,"No internet connection",Toast.LENGTH_SHORT).show();
        }else {
            try {
                if (userInput.equals("")) {
                    Toast.makeText(this, "Field required", Toast.LENGTH_SHORT).show();
                    userinput = Double.parseDouble(userInput);
                } else {
                    userinput = Double.parseDouble(userInput);
                    result = rate * userinput;
                    resultText = (TextView) findViewById(R.id.result_text);
                    resultText.setVisibility(View.VISIBLE);
                    resultText.setText(result + spinner2text);
                }

            } catch (NumberFormatException ex) {
                Toast.makeText(this, "Field required", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
