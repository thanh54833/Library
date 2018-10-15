package com.example.thanh.library.downloads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Environment;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mylibrary.DownloadUrl;
import com.example.mylibrary.Util;
import com.example.thanh.library.R;

import java.io.File;

public class Download extends AppCompatActivity {

    private BoundService boundService=null;
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

        /*Util.toast(getApplicationContext(),"start downloading ...");
        Intent intent = new Intent(this, DownloadService.class);
        startService(intent);*/

        //Intent intent=new Intent(this,BoundService.class);
        //bindService(intent,serviceConnection,BIND_AUTO_CREATE);

        //File file=Environment.getExternalStorageDirectory();
        ///DownloadUrl.urlConnection urlConnection=new DownloadUrl.urlConnection("http://androhub.com/demo/demo.pdf",file);



    }

    ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            BoundService.BoundExample iBin= (BoundService.BoundExample) iBinder;
            boundService=iBin.getSevice();

            Toast.makeText(getApplicationContext(),"Connectiong ... :"+boundService.download(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {


            Toast.makeText(getApplicationContext(),"Disconnectiong ...",Toast.LENGTH_SHORT).show();

        }
    };


}
