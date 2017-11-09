package com.example.brainbell.btcconverter.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by BRAINBELL on 04-Nov-17.
 */

public class CurrencyClass {

    @SerializedName("USD")
    @Expose
    private Double uSD;
    @SerializedName("CAD")
    @Expose
    private Double cAD;
    @SerializedName("EUR")
    @Expose
    private Double eUR;
    @SerializedName("GBP")
    @Expose
    private Double gBP;
    @SerializedName("CNY")
    @Expose
    private Double cNY;
    @SerializedName("CHF")
    @Expose
    private Double cHF;
    @SerializedName("AUD")
    @Expose
    private Double aUD;
    @SerializedName("JPY")
    @Expose
    private Double jPY;
    @SerializedName("SEK")
    @Expose
    private Double sEK;
    @SerializedName("MXN")
    @Expose
    private Double mXN;
    @SerializedName("NZD")
    @Expose
    private Double nZD;
    @SerializedName("SGD")
    @Expose
    private Double sGD;
    @SerializedName("HKD")
    @Expose
    private Double hKD;
    @SerializedName("NOK")
    @Expose
    private Double nOK;
    @SerializedName("TRY")
    @Expose
    private Double tRY;
    @SerializedName("RUB")
    @Expose
    private Double rUB;
    @SerializedName("ZAR")
    @Expose
    private Double zAR;
    @SerializedName("BRL")
    @Expose
    private Double bRL;
    @SerializedName("MYR")
    @Expose
    private Double mYR;
    @SerializedName("NGN")
    @Expose
    private Double nGN;
    public CurrencyClass(Double nGN,Double mYR,Double bRL, Double zAR,Double rUB,Double tRY,Double nOK, Double hKD,Double sGD,
               Double nZD,Double sEK,Double jPY,Double mXN,Double aUD,Double cHF,Double uSD,Double eUR,Double cAD,Double cNY){
        this.nGN=nGN;
        this.mYR=mYR;
        this.bRL=bRL;
        this.zAR=zAR;
        this.rUB=rUB;
        this.tRY=tRY;
        this.nGN=nGN;
        this.nOK=nOK;
        this.hKD=hKD;
        this.sGD=sGD;
        this.nZD=nZD;
        this.sEK=sEK;
        this.jPY=jPY;
        this.mXN=mXN;
        this.aUD=aUD;
        this.cHF=cHF;
        this.uSD=uSD;
        this.eUR=eUR;
        this.cAD=cAD;
        this.cNY=cNY;

    }

    public CurrencyClass() {
        this.nGN=0.0;
        this.mYR=0.0;
        this.bRL=0.0;
        this.zAR=0.0;
        this.rUB=0.0;
        this.tRY=0.0;
        this.nGN=0.0;
        this.nOK=0.0;
        this.hKD=0.0;
        this.sGD=0.0;
        this.nZD=0.0;
        this.sEK=0.0;
        this.jPY=0.0;
        this.mXN=0.0;
        this.aUD=0.0;
        this.cHF=0.0;
        this.uSD=0.0;
        this.eUR=0.0;
        this.cAD=0.0;
        this.cNY=0.0;
    }
    public Double getUSD() {
        return uSD;
    }

    public Double getCAD() {
        return cAD;
    }

    public Double getEUR() {
        return eUR;
    }

    public Double getGBP() {
        return gBP;
    }

    public Double getCNY() {
        return cNY;
    }

    public Double getCHF() {
        return cHF;
    }

    public Double getAUD() {
        return aUD;
    }

    public Double getJPY() {
        return jPY;
    }

    public Double getSEK() {
        return sEK;
    }

    public Double getMXN() {
        return mXN;
    }

    public Double getNZD() {
        return nZD;
    }

    public Double getSGD() {
        return sGD;
    }

    public Double getHKD() {
        return hKD;
    }

    public Double getNOK() {
        return nOK;
    }

    public Double getTRY() {
        return tRY;
    }

    public Double getRUB() {
        return rUB;
    }


    public Double getZAR() {
        return zAR;
    }

    public Double getBRL() {
        return bRL;
    }

    public Double getMYR() {
        return mYR;
    }

    public Double getNGN() {
        return nGN;
    }


}


