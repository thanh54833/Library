package com.example.testmovie.pojo;

import com.google.gson.annotations.SerializedName;

public class LoginFail {

    @SerializedName("message")
    public Message message;
    @SerializedName("error")
    public boolean error;
    @SerializedName("status")
    public Integer status;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
