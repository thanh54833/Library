package com.example.appmovie.model;

import java.util.ArrayList;
import java.util.List;

public class UserInterator {
    private loadListener loadListener;

    public UserInterator(com.example.appmovie.model.loadListener loadListener) {
        this.loadListener = loadListener;
    }

    public void createListData(){

        List<Item> list = new ArrayList<>();
        for (int i = 0 ; i < 5; i++){
            Item item = new Item("item number :"+i);
            list.add(item);
        }
        loadListener.loadSuccess(list);


    }
}
