package com.example.appmovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appmovie.model.Item;
import com.example.appmovie.presenter.ILoginPresenter;
import com.example.appmovie.presenter.MainPresenter;
import com.example.appmovie.presenter.loginPersenter;
import com.example.appmovie.retrofix.model.Products;
import com.example.appmovie.retrofix.service.APIService;
import com.example.appmovie.retrofix.service.TokenRequest;
import com.example.appmovie.view.ILoginView;
import com.example.appmovie.view.ListItem;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity  implements ILoginView ,ListItem {

    private MainPresenter mainPresenter;
    private ListView listView;

    String TAG ="com.example.appmovie";
    String URL_GET_PRODUCT = "http://training-movie.bsp.vn:82/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*String mail="pham54833@gmail.com";
        String pass="Lumia520";
        ILoginPresenter iLoginPresenter=new loginPersenter(this);
        iLoginPresenter.onLogin(mail,pass);

       listView=findViewById(R.id.list_view);
       mainPresenter = new MainPresenter(this);
       int flag=0;
       if(flag==0){
           mainPresenter.loadData();
       }
       */

       getAllProduct();
    }
    private void getAllProduct() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://training-movie.bsp.vn:82/movie/").addConverterFactory(GsonConverterFactory.create()).build();

        APIService apiService = retrofit.create(APIService.class);

        TokenRequest tokenRequest=new TokenRequest();
        tokenRequest.setApp_token("dCuW7UQMbdvpcBDfzolAOSGFIcAec11a");

        //Call<List<Products>> call = apiService.getAllProduct();

        Call<List<Products>> call = apiService.getAllProduct();

        Toast.makeText(getApplicationContext(),"start retrofix ...",Toast.LENGTH_SHORT).show();

        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Response<List<Products>> response, Retrofit retrofit) {
                List<Products> productsList = response.body();
                //String string=productsList
               /* for (int i = 0; i<productsList.size() ; i++) {
                    productList.add(productsList.get(i));
                    Log.d(TAG, "onResponse" + productsList.get(i).toString());
                }*/
                //productList.get()
                //productAdapter.notifyDataSetChanged();
                //Toast.makeText(getApplicationContext(),"leng array :"+productsList.get(1).toString(),Toast.LENGTH_SHORT).show();
                //Log.d("com.example.appmovie", productsList.get(1).getProductName());
                //Toast.makeText(getApplicationContext(),"result :"+productsList.get(1).getProductName(),Toast.LENGTH_SHORT).show();

                /*for(int i=0;i<productsList.size();i++){
                    Log.d("thegioicuathanh","---"+productsList.get(i).getProductName());
                }*/
                Toast.makeText(getApplicationContext(),"lenght :"+productsList.size(),Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onFailure(Throwable t) {
                Log.e("com.example.appmovie", "onFailure: " + t.getMessage());
                Toast.makeText(getApplicationContext(),"fail :"+t.getMessage(),Toast.LENGTH_SHORT).show();
            }

        });
    }


    @Override
    public void onLoginSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onLoginError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayMain(List<Item> list) {
        listView.setAdapter(new ArrayAdapter<Item>(this,android.R.layout.simple_list_item_1,list));
    }
}
