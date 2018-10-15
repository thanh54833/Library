package com.example.thanh.library.downloads;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.widget.Toast;

import com.example.mylibrary.DownloadUrl;

import java.io.File;

public class BoundService extends Service {


    private IBinder iBinder=new BoundExample();
    @Override
    public IBinder onBind(Intent intent) {

        Toast.makeText(this,"on Bind ",Toast.LENGTH_SHORT).show();
       return iBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {

        Toast.makeText(this,"Un Bind ",Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {

        Toast.makeText(this,"On Create ",Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"On Destroy ",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }


    public class BoundExample extends Binder {
        public BoundService getSevice() {
            return BoundService.this;
        }
    }

    public String showTime(){


        return "Thanh_Thanh";
    }

    public int download(){
        File file=Environment.getExternalStorageDirectory();
        DownloadUrl.urlConnection urlConnection=new DownloadUrl.urlConnection("http://androhub.com/demo/demo.pdf",file);
        return urlConnection.proscess;
    }


}
