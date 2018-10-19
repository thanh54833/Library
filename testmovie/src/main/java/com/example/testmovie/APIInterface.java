package com.example.testmovie;

import com.example.testmovie.pojo.Datas;
import com.example.testmovie.pojo.Login;
import com.example.testmovie.pojo.User;
import com.example.testmovie.pojo.UserTest;
import com.squareup.okhttp.RequestBody;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Header;
import retrofit.http.POST;

/**
 * Created by anupamchugh on 09/01/17.
 */

public interface APIInterface {
    /*@GET("/api/unknown")
    Call<MultipleResource> doGetListResources();
    */




    @POST("/api/users")
    Call<User> createUser(@Body UserTest user);

    @FormUrlEncoded
    @POST("/user/login")
    Call<Login> onLogin(@Header("app_token") String authKey,@Field("email") String email,@Field("password") String password);//,@Body Datas data);



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
