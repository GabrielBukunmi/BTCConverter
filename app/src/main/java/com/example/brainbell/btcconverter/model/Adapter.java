package com.example.brainbell.btcconverter.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brainbell.btcconverter.R;
import com.example.brainbell.btcconverter.controller.ConversionScreenActivity;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.ssp;
import static com.example.brainbell.btcconverter.R.id.baseCurrency;
import static com.example.brainbell.btcconverter.R.id.spinner1;
import static com.example.brainbell.btcconverter.R.id.spinner2;

/**
 * Created by BRAINBELL on 01-Nov-17.
 */

public class Adapter  extends  RecyclerView.Adapter<Adapter.MyViewHolder>{

    ArrayList<Double> mList = new ArrayList<>();
   private String spinner1text="";
    private String spinner2text="";
    private Double rate=0.0;

    private Context mContext;

    public Adapter(Context context) {
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_listview,
                parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Double d = mList.get(position);

        holder.spinner1Txt.setText(String.valueOf(spinner1text));
        holder.spinner2Txt.setText(String.valueOf(spinner2text));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent (mContext,ConversionScreenActivity.class);
                intent.putExtra("spinner1text",spinner1text);
                intent.putExtra("spinner2text",spinner2text);
                intent.putExtra("rate",mList.get(position));
                mContext.startActivity(intent);
            }
        });
        holder.deleteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeCard(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addItem(Double d,String spinner1text,String spinner2text) throws IndexOutOfBoundsException{
       try {
           this.spinner1text=spinner1text;
           this.spinner2text=spinner2text;
           rate=d;
           mList.add(d);
           notifyItemInserted(mList.size() - 1);
       } catch(Exception e){
           Log.e("Error adding list:", "",e);
       }

    }
    private void removeCard(int position) throws IndexOutOfBoundsException{
        try{
            mList.remove(position);
            notifyItemRemoved(position - 1);
        } catch (Exception e) {
            Log.e("List is empty: ", "",e);
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

            TextView spinner1Txt;
            TextView spinner2Txt;
            ImageView deleteCard;
            public MyViewHolder(View itemView) {
                super(itemView);

                spinner1Txt = (TextView) itemView.findViewById(R.id.first_currency);
                spinner2Txt = (TextView) itemView.findViewById(R.id.second_currency);
                deleteCard=(ImageView) itemView.findViewById(R.id.remove_card);
            }
        }
    }


