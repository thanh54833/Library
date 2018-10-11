package com.example.thanh.library;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mylibrary.DownloadUrl;

import java.io.File;
import java.io.IOException;

public class Download extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        String iamge="https://imagejournal.org/wp-content/uploads/bb-plugin/cache/23466317216_b99485ba14_o-panorama.jpg";
        File file = new File(Environment.getExternalStorageDirectory(),"/khong");
        try {
            DownloadUrl.downloadFile(iamge,String.valueOf(file));
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Error :"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }


    }


}
