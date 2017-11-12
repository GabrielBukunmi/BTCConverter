package com.example.brainbell.btcconverter.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ItemResponse {

    @SerializedName("BTC")
    @Expose
    private  CurrencyClass bTC;
    @SerializedName("ETH")
    @Expose
    private CurrencyClass eTH;

    /*getter methods for BTC and ETH*/
    public CurrencyClass getBTC() {
        return bTC;
    }

    public CurrencyClass getETH() {
        return eTH;
    }


}
