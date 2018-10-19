package com.example.myapplication.retrofix.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datas {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("updated_at")
    @Expose
    private String updated_at;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("created_at")
    @Expose
    private String created_at;
    @SerializedName("google_id")
    @Expose
    private String google_id;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("facebook_id")
    @Expose
    private String facebook_id;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("access_token")
    @Expose
    private String access_token;
    @SerializedName("full_name")
    @Expose
    private String full_name;


    public Datas(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getGoogle_id() {
        return google_id;
    }

    public void setGoogle_id(String google_id) {
        this.google_id = google_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", birthday = "+birthday+", updated_at = "+updated_at+", email = "+email+", created_at = "+created_at+", google_id = "+google_id+", gender = "+gender+", facebook_id = "+facebook_id+", password = "+password+", access_token = "+access_token+", full_name = "+full_name+"]";
    }
}
