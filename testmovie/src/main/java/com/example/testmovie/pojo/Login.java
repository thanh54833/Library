package com.example.testmovie.pojo;

import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("message")
    public String message;
    @SerializedName("error")
    public String error;
    @SerializedName("data")
    public Datas data;
    @SerializedName("code")
    public String code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Datas getData() {
        return data;
    }

    public void setData(Datas data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", error = "+error+", data = "+data+", code = "+code+"]";
    }

}
