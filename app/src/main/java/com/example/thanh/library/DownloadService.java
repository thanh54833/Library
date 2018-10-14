package com.example.thanh.library;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;

import com.example.mylibrary.DownloadUrl;

import java.io.File;

public class DownloadService extends IntentService {

    public DownloadService() {
        super("DownloadService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {

        File file=Environment.getExternalStorageDirectory();
        DownloadUrl.urlConnection("http://androhub.com/demo/demo.pdf",file);

    }


}