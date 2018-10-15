package com.example.appmovie.presenter;

import com.example.appmovie.model.Item;
import com.example.appmovie.model.UserInterator;
import com.example.appmovie.model.loadListener;
import com.example.appmovie.view.ListItem;


import java.util.List;

public class MainPresenter implements loadListener {

    private ListItem listItem;
    private UserInterator userInterator;


    public MainPresenter(ListItem listItem) {
        this.listItem = listItem;
        userInterator = new UserInterator(this);
    }

    public void loadData(){
        userInterator.createListData();
    }

    @Override
    public void loadSuccess(List<Item> list) {
        listItem.displayMain(list);
    }

    @Override
    public void loadFail(String message) {

    }
}
