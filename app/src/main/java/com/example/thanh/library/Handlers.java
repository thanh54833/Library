package com.example.thanh.library;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Message;
import android.widget.Toast;

import com.example.mylibrary.Util;

public class Handlers extends AppCompatActivity implements View.OnClickListener{
    private TextView textView;
    private Button button;
    private android.os.Handler mHandler;
    private static final int Message_Count_Down = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);


        //init();
        //initHandler();
        //byte[] bytes="pham hoai thanh".getBytes();
       /* Parses p=new Parses();
        p.add("thanh".getBytes());
        p.add("hoai".getBytes());
        p.add("pham".getBytes());
        byte[]bytes=p.getBuffer();
        p.Close();
        ByteArrayInputStream bInput = new ByteArrayInputStream(bytes);
        bInput.mark(4);
        byte[] b=new byte[4];
        for(int i=0;i<4;i++){
            b[i]=bytes[i];
        }
        //Log.d("byte","mark :"+new String(b));
        */
    }


    private void initHandler() {
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {

                switch (msg.what) {
                    case Message_Count_Down:
                        textView.setText("" + msg.arg1);
                        break;
                    case 1001:
                        textView.setText("Done");
                        break;
                    default:
                        break;
                }
            }
        };


    }

    private void init() {
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.button):
                doCountDowcn();
                Toast.makeText(getApplicationContext(), "Click", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private void doCountDowcn() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                int time = 10;
                while (time > 0) {

                    time--;
                    Message msg = new Message();
                    msg.what = Message_Count_Down;
                    msg.arg1 = time;
                    mHandler.sendMessage(msg);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        if (BuildConfig.DEBUG) {
                            Util.messageDisplay("Error :" + e.getMessage());
                        }
                    }
                }
                mHandler.sendEmptyMessage(1001);

            }
        });

        thread.start();
    }

}
