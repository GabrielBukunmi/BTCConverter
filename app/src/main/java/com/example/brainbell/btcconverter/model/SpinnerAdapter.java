package com.example.brainbell.btcconverter.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brainbell.btcconverter.R;


public class SpinnerAdapter extends  BaseAdapter{
        Context context;
        String[] currencyNames;
        LayoutInflater inflter;

        public SpinnerAdapter(Context applicationContext, String [] currencyNames) {
            this.context = applicationContext;
            this.currencyNames = currencyNames;
            inflter = (LayoutInflater.from(applicationContext));
        }

        @Override
        public int getCount() {
            return currencyNames.length;
        }

        @Override
        public Object getItem(int i) {
            return currencyNames[i];
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = inflter.inflate(R.layout.custom_spinner_item, null);
            TextView names = (TextView) view.findViewById(R.id.textView);
            names.setText(currencyNames[i]);
            return view;
        }
}
