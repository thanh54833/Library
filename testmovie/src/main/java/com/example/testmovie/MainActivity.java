package com.example.testmovie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.testmovie.pojo.Datas;
import com.example.testmovie.pojo.Login;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


public class MainActivity extends AppCompatActivity {

    TextView responseText;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseText = (TextView) findViewById(R.id.responseText);


        apiInterface = APIClient.getClient().create(APIInterface.class);

        //Account account=;
        //
        //new ("namnguyen.290493@gmail.com","Lumia520")
        //jsonObject.toString()
        //final Call<Login> call = apiInterface.onLogin("dCuW7UQMbdvpcBDfzolAOSGFIcAec11a","phamhoaithanh3@gmail.com","Lumia520");
        //final Call<Login> call = apiInterface.onLogin("dCuW7UQMbdvpcBDfzolAOSGFIcAec11a",jsonObject.toString());


        final Call<Login> call = apiInterface.onLogin("dCuW7UQMbdvpcBDfzolAOSGFIcAec11a","phamhoaithanh32@gmail.com","Lumia520");//,account);
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Response<Login> response, Retrofit retrofit) {

                Login login=response.body();
                responseText.setText(null);

                responseText.append("code :"+login.getCode()+"\n");
                responseText.append("message :"+login.getMessage()+"\n");
                responseText.append("id :"+login.data.getId()+"\n");
                responseText.append("email :"+login.data.getEmail()+"\n");
                responseText.append("password :"+login.data.getPassword()+"\n");
                responseText.append("full_name :"+login.data.getFull_name()+"\n");
                responseText.append("gender :"+login.data.getGender()+"\n");
                responseText.append("birthday :"+login.data.getBirthday()+"\n");
                responseText.append("facebook_id :"+login.data.getFacebook_id()+"\n");
                responseText.append("google_id :"+login.data.getGoogle_id()+"\n");
                responseText.append("access_token :"+login.data.getAccess_token()+"\n");
                responseText.append("created_at :"+login.data.getCreated_at()+"\n");
                responseText.append("updated_at :"+login.data.getUpdated_at()+"\n");
            }
            @Override
            public void onFailure(Throwable t) {
                call.cancel();
                responseText.append("Error :"+t.getMessage());
            }
        });

        /*final Call<MultipleResource> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<MultipleResource>() {
            @Override
            public void onResponse(Response<MultipleResource> response, Retrofit retrofit) {
                Log.d("TAG",response.code()+"");
                String displayResponse = "";
                MultipleResource resource = response.body();
                /*Integer text = resource.page;
                Integer total = resource.total;
                Integer totalPages = resource.totalPages;
                List<MultipleResource.Datum> datumList = resource.data;
                displayResponse += text + " Page\n" + total + " Total\n" + totalPages + " Total Pages\n";
                for (MultipleResource.Datum datum : datumList) {
                    displayResponse += datum.id + " " + datum.name + " " + datum.pantoneValue + " " + datum.year + "\n";
                }
               // responseText.setText(displayResponse);*/
                //responseText.setText("pham hoai thanh :"+resource.toString());
                /*responseText.setText(null);
                responseText.append("result :\n");
                responseText.append("getPage :"+resource.getPage()+"\n");
                responseText.append("getPerPage :"+resource.getPerPage()+"\n");
                responseText.append("getTotal :"+resource.getTotal()+"\n");
                responseText.append("getTotalPages :"+resource.getTotalPages()+"\n");
                responseText.append("getData :\n");
                for(MultipleResource.Datum datum:resource.getData()){
                    responseText.append("getId :"+String.valueOf(datum.getId())+"\n");
                    responseText.append("getName :"+String.valueOf(datum.getName())+"\n");
                    responseText.append("getYear :"+String.valueOf(datum.getYear())+"\n");
                    responseText.append("getPantoneValue :"+String.valueOf(datum.getPantoneValue())+"\n");
                }
            }
            @Override
            public void onFailure(Throwable t) {
                call.cancel();
                Toast.makeText(getApplicationContext(),"Error :"+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        /**
         Create new user
         **/


        /*UserTest user = new UserTest("morpheus", "leader","10");
        final Call<User> call = apiInterface.createUser(user);

        //Call<User> call1 = apiInterface.createUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response, Retrofit retrofit) {

                User user1 = response.body();

                Toast.makeText(getApplicationContext(), user1.name + " " + user1.job + " " + user1.id + " " + user1.createdAt, Toast.LENGTH_SHORT).show();
                String s="getId :"+user1.getId()+"getCreatedAt :"+user1.getCreatedAt()+"\n"+"getName :"+user1.getName()+"getJob :"+user1.getJob();
                responseText.setText("result :"+s);
            }
            @Override
            public void onFailure(Throwable t) {

                call.cancel();
                Toast.makeText(getApplicationContext(),"Error :"+t.getMessage(),Toast.LENGTH_SHORT).show();
                responseText.setText("result :"+t.getMessage());

            }
        });*/


        /**
         GET List Users
         **/
        /*Call<UserList> call2 = apiInterface.doGetUserList("2");
        call2.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Response<UserList> response, Retrofit retrofit) {
                UserList userList = response.body();
                Integer text = userList.page;
                Integer total = userList.total;
                Integer totalPages = userList.totalPages;
                List<UserList.Datum> datumList = userList.data;
                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();
                for (UserList.Datum datum : datumList) {
                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Throwable t) {
                call.cancel();
                Toast.makeText(getApplicationContext(),"Error :"+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });*/
        /**
         POST name and job Url encoded.
         **/
       /*Call<UserList> call3 = apiInterface.doCreateUserWithField("morpheus","leader");
        call3.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Response<UserList> response, Retrofit retrofit) {
                UserList userList = response.body();
                String s;
                responseText.setText(null);
                responseText.append("page :"+userList.getPage()+"\n");
                responseText.append("per_page :"+userList.getPerPage()+"\n");
                responseText.append("total :"+userList.getTotal());
                responseText.append("total_pages :"+userList.getTotalPages()+"\n");
                responseText.append("Data :\n");
                for (UserList.Datum datum : userList.getData()){
                    responseText.append("id :"+datum.getId()+"\n");
                    responseText.append("first_name :"+datum.getFirst_name()+"\n");
                    responseText.append("last_name :"+datum.getLast_name()+"\n");
                    responseText.append("avatar :"+datum.getAvatar()+"\n");
                }
                /*Integer text = userList.page;
                Integer total = userList.total;
                Integer totalPages = userList.totalPages;
                List<UserList.Datum> datumList = userList.data;
                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();
                for (UserList.Datum datum : datumList) {
                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar, Toast.LENGTH_SHORT).show();
                }*/
            /*}
            @Override
            public void onFailure(Throwable t) {
                call.cancel();
                Toast.makeText(getApplicationContext(),"Error :"+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });*/


    }
}
