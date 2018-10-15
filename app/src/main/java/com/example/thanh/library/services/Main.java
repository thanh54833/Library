package com.example.thanh.library.services;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.thanh.library.R;

public class Main extends AppCompatActivity implements View.OnClickListener {

    private Button btn_start=null;
    private Button btn_stop=null;

    private Button btn_start1=null;
    private Button btn_stop1=null;

    public static final String MESSAGE="message";

    BoundService boundService=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();
    }

    private void init() {

        btn_start=findViewById(R.id.btn_start);
        btn_stop=findViewById(R.id.btn_stop);

        btn_stop.setOnClickListener(this);
        btn_start.setOnClickListener(this);

        btn_start1=findViewById(R.id.btn_start1);
        btn_stop1=findViewById(R.id.btn_stop1);

        btn_stop1.setOnClickListener(this);
        btn_start1.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(this,StartService.class);
        intent.putExtra(MESSAGE,"thanh");

        Intent intent1=new Intent(this,BoundService.class);

        switch (view.getId()){
            case R.id.btn_start:
                startService(intent);
                break;
            case R.id.btn_stop:
                stopService(intent);
                break;
            case R.id.btn_start1:
                bindService(intent1,serviceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.btn_stop1:
                unbindService(serviceConnection);
                break;

        }


    }

    ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            BoundService.BoundExample  iBinde= (BoundService.BoundExample) iBinder;
            boundService=iBinde.getSevice();

            Toast.makeText(getApplicationContext(),"Service connection... :"+boundService.showTime(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

            Toast.makeText(getApplicationContext(),"Service Disconnection...", Toast.LENGTH_SHORT).show();
        }
    };


}
