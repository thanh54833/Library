package com.example.thanh.library.downloads;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;
import android.widget.Toast;

import com.example.mylibrary.DownloadUrl;
import com.example.mylibrary.Util;

import java.io.File;

public class DownloadService extends IntentService {

    public DownloadService() {
        super("DownloadService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {

        File file=Environment.getExternalStorageDirectory();

        DownloadUrl.urlConnection urlConnection=new DownloadUrl.urlConnection("http://androhub.com/demo/demo.pdf",file);

        //DownloadUrl.urlConnection("http://androhub.com/demo/demo.pdf",file);
        //Toast.makeText(this,"process :"+urlConnection.proscess,Toast.LENGTH_SHORT).show();

        Util.messageDisplay("process :"+urlConnection.proscess);

    }


}