package com.example.testmovie;


import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by anupamchugh on 05/01/17.
 */

public class APIClient {

    private static Retrofit retrofit = null;

    static Retrofit getClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl("http://training-movie.bsp.vn:82")
                //.baseUrl("https://reqres.in")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }
}
