package com.example.appmovie.model;

public class Item {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Item(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        //return "Demo{" + "message='" + message + '\'' + '}';
        return message;
    }


}
