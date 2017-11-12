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

import com.example.brainbell.btcconverter.R;
import com.example.brainbell.btcconverter.controller.ConversionScreenActivity;

import java.util.ArrayList;

public class Adapter  extends  RecyclerView.Adapter<Adapter.MyViewHolder>{

    /*This is the recylcler view adapter codes*/

    private ArrayList<Double> mList = new ArrayList<>();
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
    public void onBindViewHolder(final MyViewHolder holder,
                                 int position) throws IndexOutOfBoundsException {
        try {
            final Double d = mList.get(position);

            holder.spinner1Txt.setText(String.valueOf(spinner1text));
            holder.spinner2Txt.setText(String.valueOf(spinner2text));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ConversionScreenActivity.class);
                    intent.putExtra("spinner1text", spinner1text);
                    intent.putExtra("spinner2text", spinner2text);
                    intent.putExtra("rate",d);
                    mContext.startActivity(intent);
                }
            });
            holder.deleteCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeCard(holder.getAdapterPosition());
                }
            });
        } catch (Exception e) {
            Log.e("Error", "index out of bounds exception");
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    /*The addItem method below is to add cards to the recylcer view list */
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
    /*RemoveCard method is to remove cards from the recylcer view list*/
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


