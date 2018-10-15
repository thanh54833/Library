package com.example.appmovie.presenter;

import com.example.appmovie.model.User;
import com.example.appmovie.view.ILoginView;

public class loginPersenter implements ILoginPresenter {

    ILoginView loginView;

    public loginPersenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {

        User user=new User(email,password);
        int isLoginSucces=user.isValiData();
        if(isLoginSucces==0){
            loginView.onLoginError("login error ...");
        }
        if(isLoginSucces==1){
            loginView.onLoginError("login error ...");
        }
        if(isLoginSucces==2){
            loginView.onLoginError("login error ...");
        }
        if(isLoginSucces==3){
            loginView.onLoginSuccess("login success ...");
        }
        else {
            loginView.onLoginSuccess("login failed ...");
        }

    }
}
