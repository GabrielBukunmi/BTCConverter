package com.example.brainbell.btcconverter.controller;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.design.widget.FloatingActionButton;
import
        android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brainbell.btcconverter.R;
import com.example.brainbell.btcconverter.api.Client;
import com.example.brainbell.btcconverter.api.Service;
import com.example.brainbell.btcconverter.model.Adapter;
import com.example.brainbell.btcconverter.model.CurrencyClass;
import com.example.brainbell.btcconverter.model.ItemResponse;
import com.example.brainbell.btcconverter.model.Spinner1Adapter;
import com.example.brainbell.btcconverter.model.SpinnerAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.key;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.os.Build.VERSION_CODES.M;
import static android.view.animation.AnimationUtils.loadAnimation;
import static com.example.brainbell.btcconverter.R.id.refresh;

public class MainActivity extends AppCompatActivity {
    String[] currencyNames = {"USD", "CAD", "EUR", "GBP", "CNY", "CHF", "AUD", "JPY", "SEK", "MXN", "NZD",
            "SGD", "HKD", "NOK", "TRY", "RUB", "ZAR", "BRL", "MYR", "NGN"
    };
    String[] BaseCurrency = {"BTC", "ETH"};
    ArrayList<Double> mList = new ArrayList<Double>();
    ItemResponse itemResponse;
    Adapter listAdapter;
    Spinner spinner1;
    Spinner spinner2;
    CurrencyClass bTC;
    MenuItem item;
    CurrencyClass eTH;
    public String spinner2text;
    public String spinner1text;
    private Animation rotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listAdapter = new Adapter(this);
        bTC=new CurrencyClass();
        eTH= new CurrencyClass();
        loadJSON();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner1 = (Spinner) findViewById(R.id.spinner1);


        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(getApplicationContext(), currencyNames);

        spinner2.setAdapter(spinnerAdapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner2text = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner1Adapter spinner1Adapter = new Spinner1Adapter(getApplicationContext(), BaseCurrency);
        spinner1.setAdapter(spinner1Adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner1text = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void Createcard(View v) {
        loadJSON();
        double rate= getRate(formKey(spinner1text,spinner2text));
        create(rate, spinner1text, spinner2text);

    }

    private void create(Double u, String spiner1text, String spiner2text) {
        listAdapter.addItem(u, spiner1text, spiner2text);
    }


    private void loadJSON() {
        try {
            Client Client = new Client();
            Service apiService = Client.getClient().create(Service.class);
            Call<ItemResponse> call = apiService.getItemResponse();
            call.enqueue(new Callback<ItemResponse>() {
                @Override
                public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                    if (response.isSuccessful()) {
                        bTC = response.body().getBTC();
                        eTH = response.body().getETH();
                    Toast.makeText(MainActivity.this,"connected to the internet",Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<ItemResponse> call, Throwable throwable) {
                    Log.d("Error", throwable.getMessage());
                    Toast.makeText(MainActivity.this,"Error connecting to the internet",Toast.LENGTH_SHORT).show();

                }
            });


        } catch (Exception exception) {
            Log.d("Error", exception.getMessage());
            Toast.makeText(this,exception.toString(),Toast.LENGTH_SHORT).show();
        }
    }


    public double getRate(String key) throws NullPointerException{
        double rate = 0.0;
        try {
            switch (key) {
                case "BTC-NGN":
                    rate = bTC.getNGN();
                    break;
            case "BTC-USD":
                rate = bTC.getUSD();
                break;
                case "BTC-MYR":
                    rate = bTC.getMYR();
                    break;
                case "BTC-EUR":
                    rate = bTC.getEUR();
                    break;
                case "BTC-GBP":
                    rate = bTC.getGBP();
                    break;
                case "BTC-SGD":
                    rate = bTC.getSGD();
                    break;
                case "BTC-SEK":
                    rate = bTC.getSEK();
                    break;
                case "BTC-TRY":
                    rate = bTC.getTRY();
                    break;
                case "BTC-ZAR":
                    rate = bTC.getZAR();
                    break;
                case "BTC-CNY":
                    rate = bTC.getCNY();
                    break;
                case "BTC-AUD":
                    rate = bTC.getAUD();
                    break;
                case "BTC-CHF":
                    rate = bTC.getCHF();
                    break;
                case "BTC-CAD":
                    rate = bTC.getCAD();
                    break;
                case "BTC-NZD":
                    rate = bTC.getNZD();
                    break;
                case "BTC-HKD":
                    rate = bTC.getHKD();
                    break;
                case "BTC-BRL":
                    rate = bTC.getBRL();
                    break;
                case "BTC-MXN":
                    rate = bTC.getMXN();
                    break;
                case "BTC-RUB":
                    rate = bTC.getRUB();
                    break;
                case "BTC-NOK":
                    rate = bTC.getNOK();
                    break;
                case "BTC-JPY":
                    rate = bTC.getJPY();
                    break;

                /*switch statements for ETH*/


                case "ETH-NGN":
                    rate = eTH.getNGN();
                    break;
                case "ETH-USD":
                    rate = eTH.getUSD();
                    break;
                case "ETH-MYR":
                    rate = eTH.getMYR();
                    break;
                case "ETH-EUR":
                    rate = eTH.getEUR();
                    break;
                case "ETH-GBP":
                    rate = eTH.getGBP();
                    break;
                case "ETH-SGD":
                    rate = eTH.getSGD();
                    break;
                case "ETH-SEK":
                    rate = eTH.getSEK();
                    break;
                case "ETH-TRY":
                    rate = eTH.getTRY();
                    break;
                case "ETH-ZAR":
                    rate = eTH.getZAR();
                    break;
                case "ETH-CNY":
                    rate = eTH.getCNY();
                    break;
                case "ETH-AUD":
                    rate = eTH.getAUD();
                    break;
                case "ETH-CHF":
                    rate = eTH.getCHF();
                    break;
                case "ETH-CAD":
                    rate = eTH.getCAD();
                    break;
                case "ETH-NZD":
                    rate = eTH.getNZD();
                    break;
                case "ETH-HKD":
                    rate = eTH.getHKD();
                    break;
                case "ETH-BRL":
                    rate = eTH.getBRL();
                    break;
                case "ETH-MXN":
                    rate = eTH.getMXN();
                    break;
                case "ETH-RUB":
                    rate = eTH.getRUB();
                    break;
                case "ETH-NOK":
                    rate = eTH.getNOK();
                    break;
                case "ETH-JPY":
                    rate = eTH.getJPY();
                    break;
            }
        } catch (Exception e) {
            Log.d("null pointer exception",e.getMessage());
        }

        return rate;
    }

    public String formKey(String a, String b) {
        return a+"-"+b;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.conversionscreenmenu,menu);
        MenuItem menuItem= menu.findItem(R.id.refresh);
        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                loadJSON();
                return true;
            }
        });
        return true;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}




