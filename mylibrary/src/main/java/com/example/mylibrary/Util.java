package com.example.mylibrary;

import android.util.Log;

public class Util {

    public static void messageDisplay(String message){
        if(BuildConfig.DEBUG){
            Log.i("com.example.mylibrary",message);
        }

    }
}
