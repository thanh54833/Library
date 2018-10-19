package com.example.appmovie.retrofix.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public  class Products implements Serializable {

    @SerializedName("error")
    private  String error;

    @SerializedName("code")
    private  String code;

    @SerializedName("message")
    private  String message;


   /* @SerializedName("id_product")
    private  int idProduct;
    @SerializedName("product_name")
    private  String productName;
    @SerializedName("decription")
    private  String decription;
    @SerializedName("price")
    private  String price;
    @SerializedName("thumnail")
    private  String thumnail;*/

    /*public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getThumnail() {
        return thumnail;
    }

    public void setThumnail(String thumnail) {
        this.thumnail = thumnail;
    }*/
}
