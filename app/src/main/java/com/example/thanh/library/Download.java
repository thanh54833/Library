package com.example.thanh.library;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mylibrary.DownloadUrl;
import com.example.mylibrary.Util;

import java.io.File;
import java.io.IOException;

public class Download extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        /*String iamge="http://androhub.com/demo/demo.pdf";
        File file = new File(Environment.getExternalStorageDirectory(),"/khong/thanh.png");
        try {
            DownloadUrl.downloadFile(iamge,String.valueOf(file));
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Error :"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }*/
        Util.toast(getApplicationContext(),"start downloading ...");
        Intent intent = new Intent(this, DownloadService.class);
        startService(intent);


    }


}
