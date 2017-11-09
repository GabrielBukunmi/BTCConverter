package com.example.brainbell.btcconverter.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by BRAINBELL on 01-Nov-17.
 */

public class Client {
    public static final String BASE_URL="https://min-api.cryptocompare.com";
        public static Retrofit retrofit= null;

        public static Retrofit getClient() {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }
}
