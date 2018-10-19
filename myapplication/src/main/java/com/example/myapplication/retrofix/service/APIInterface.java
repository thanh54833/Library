package com.example.myapplication.retrofix.service;


import com.example.myapplication.model.User;
import com.example.myapplication.retrofix.model.Logins;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by anupamchugh on 09/01/17.
 */

public interface APIInterface {
    /*@GET("/api/unknown")
    Call<MultipleResource> doGetListResources();
    */

    @FormUrlEncoded
    @POST("/user/login")
    Call<Logins> onLogin(@Header("app_token") String authKey, @Field("email") String email, @Field("password") String password);//,@Body Datas data);



    /*
   @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") String page);
    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);*/
    //@Headers("app_token:dCuW7UQMbdvpcBDfzolAOSGFIcAec11a")
    // @POST("/user/login")
    //Call<Login> onLogin(@Body Account account);
    //@FormUrlEncoded
    //@Headers("app_token: dCuW7UQMbdvpcBDfzolAOSGFIcAec11a")
    //@Header("app_token") String authKey
    ///@Headers("Content-Type: application/json")

    //@POST("/user/login")
    //Call<Login> onLogin(@Header("app_token") String authKey,@Query("email") String email, @Query("password")  String password);

    //@POST("/user/login")
    //Call<Login> onLogin(@Header("app_token") String authKey,@Body String body);



}
