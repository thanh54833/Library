package com.example.appmovie.retrofix.service;


import com.example.appmovie.retrofix.model.Products;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

public interface APIService {



    @GET("list")
    Call<List<Products>> getAllProduct();

    //@POST("movie/list")
    //Call<List<Products>> getAllProduct(@Body TokenRequest tokenRequest);


}