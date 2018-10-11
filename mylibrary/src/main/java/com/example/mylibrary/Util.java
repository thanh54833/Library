package com.example.mylibrary;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class Util {

    public static void messageDisplay(String message){
        if(BuildConfig.DEBUG){
            Log.i("com.example.mylibrary",message);
        }

    }
    public static void Toasts(Context context, String message) {
        if(BuildConfig.DEBUG){
            Toast.makeText(context,""+message,Toast.LENGTH_SHORT).show();
        }
    }
}
