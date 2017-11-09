package com.example.brainbell.btcconverter.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by BRAINBELL on 01-Nov-17.
 */

public class ItemResponse {

    @SerializedName("BTC")
    @Expose
    private  CurrencyClass bTC;
    @SerializedName("ETH")
    @Expose
    private CurrencyClass eTH;

    public CurrencyClass getBTC() {
        return bTC;
    }

    public CurrencyClass getETH() {
        return eTH;
    }


}
