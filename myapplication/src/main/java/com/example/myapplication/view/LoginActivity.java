package com.example.myapplication.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


import com.example.myapplication.R;
import com.example.myapplication.presenter.ILoginPresenter;
import com.example.myapplication.presenter.LoginPersenter;
import com.example.myapplication.retrofix.model.Logins;

public class LoginActivity extends AppCompatActivity implements ILoginListenerView {
    //private ILoginListener loginListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        String email ="phamhoaithanh32@gmail.com";
        String pass = "Lumia520";

        ILoginPresenter iLoginPresenter = new LoginPersenter(this);
        iLoginPresenter.onLogin(email, pass);

    }
    @Override
    public void getDataSuccess(Logins logins) {
        Toast.makeText(this, "Login success : \n get email : "+logins.data.getEmail()+"\nget name:"+logins.data.getFull_name(), Toast.LENGTH_SHORT).show();
    }
    @Override
    public void getMessageError(String e) {
        Toast.makeText(this,  "Login error :"+e, Toast.LENGTH_SHORT).show();

    }
}
