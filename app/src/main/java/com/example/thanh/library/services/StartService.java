package com.example.thanh.library.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class StartService extends Service {

    @Override
    public void onCreate() {
        Toast.makeText(this,"on create !!",Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String message=null;
        if(intent!=null){
            message=intent.getStringExtra(Main.MESSAGE);
        }
        Toast.makeText(this,"on Start Command :"+message,Toast.LENGTH_SHORT).show();
        //return super.onStartCommand(intent, flags, startId);
        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {

        Toast.makeText(this,"on Destroy!",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
