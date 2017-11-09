package com.example.brainbell.btcconverter.api;

import com.example.brainbell.btcconverter.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by BRAINBELL on 01-Nov-17.
 */

public interface Service {
        @GET("/data/pricemulti?fsyms=BTC,ETH&tsyms=USD,CAD,EUR,GBP,CNY,CHF,AUD,JPY,SEK,MXN,NZD,SGD,HKD,NOK,TRY,RUB,ZAR,BRL,MYR,NGN")
        Call<ItemResponse> getItemResponse();

}
