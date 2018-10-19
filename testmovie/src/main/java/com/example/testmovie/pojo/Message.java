package com.example.testmovie.pojo;

import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("email")
    public String[] email;
    @SerializedName("password")
    public String[] password;

    public String[] getEmail() {
        return email;
    }

    public void setEmail(String[] email) {
        this.email = email;
    }

    public String[] getPassword() {
        return password;
    }

    public void setPassword(String[] password) {
        this.password = password;
    }

    @Override
    public String toString()
    {
        String email1="";
        for (String s:email){
            email1+=s;
        }
        String password1="";
        for (String s:password){
            password1+=s;
        }


        return "ClassPojo [email = "+email1+", password = "+password1+"]";
    }
}
