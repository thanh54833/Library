package com.example.appmovie.model;

import java.util.List;

public interface loadListener {

    void loadSuccess(List<Item> listItem);
    void loadFail(String message);

}
