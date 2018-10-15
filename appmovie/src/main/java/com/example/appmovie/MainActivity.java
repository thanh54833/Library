package com.example.appmovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.appmovie.presenter.ILoginPresenter;
import com.example.appmovie.presenter.loginPersenter;
import com.example.appmovie.view.ILoginView;

public class MainActivity extends AppCompatActivity  implements ILoginView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String mail="pham54833@gmail.com";
        String pass="Lumia520";

        ILoginPresenter iLoginPresenter=new loginPersenter(this);
        iLoginPresenter.onLogin(mail,pass);


    }

    @Override
    public void onLoginSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
