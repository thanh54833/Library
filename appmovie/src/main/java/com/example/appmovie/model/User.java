package com.example.appmovie.model;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.TextView;

public class User implements IUser{

    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValiData() {
        //return !TextUtils.isEmpty(getEmail())&& Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()&&getPassword().length()>6;

        if(TextUtils.isEmpty(getEmail())){
            return 0;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()){
            return 1;
        }else if(getPassword().length()<=6){
            return 2;
        }
        else if(getEmail().equals("pham54833@gmail.com")&&getPassword().equals("Lumia520")){
            return 3;
        }
        else {
            return -1;
        }

    }
}
