package com.example.myapplication.retrofix.service;


import com.example.myapplication.retrofix.model.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {



    @GET("list")
    Call<List<Products>> getAllProduct();

    //@POST("movie/list")
    //Call<List<Products>> getAllProduct(@Body TokenRequest tokenRequest);


}