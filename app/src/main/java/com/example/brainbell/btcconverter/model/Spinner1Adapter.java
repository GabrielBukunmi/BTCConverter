package com.example.brainbell.btcconverter.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.brainbell.btcconverter.R;

/**
 * Created by BRAINBELL on 03-Nov-17.
 */

public class Spinner1Adapter extends BaseAdapter {
    Context context;
    String[] BaseCurrency;
    LayoutInflater inflter;

    public Spinner1Adapter(Context applicationContext, String[] BaseCurrency) {
        this.context = applicationContext;
        this.BaseCurrency = BaseCurrency;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return BaseCurrency.length;
    }

    @Override
    public Object getItem(int i) {
        return BaseCurrency[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.custom_spinner_item, null);
        TextView names = (TextView) view.findViewById(R.id.textView);
        names.setText(BaseCurrency[i]);
        return view;
    }
}
