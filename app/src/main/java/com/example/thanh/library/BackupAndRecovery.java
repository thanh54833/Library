package com.example.thanh.library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.mylibrary.Converter;
import com.example.mylibrary.Parses;
import com.example.mylibrary.Util;

public class BackupAndRecovery extends AppCompatActivity {

    private Button btnDownload;
    String URL = "https://imagejournal.org/wp-content/uploads/bb-plugin/cache/23466317216_b99485ba14_o-panorama.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* btnDownload = (Button) findViewById(R.id.btnDownload);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DownloadTask(MainActivity.this, URL);
            }
        });

        */
        /*Parses parses=new Parses();
        parses.add("thanh".getBytes());
        parses.add("khong".getBytes());
        parses.add("pham".getBytes());
        parses.add("thanh1".getBytes());
        parses.add("khong1".getBytes());
        parses.add("pham1".getBytes());
        parses.Close();
        byte[] buffer=parses.getBuffer();
        ByteArrayInputStream bis=new ByteArrayInputStream(buffer);
        /*Util.toast(getApplicationContext(),"result : "+bis.read());
        Util.toast(getApplicationContext(),"result : "+bis.read());
        Util.toast(getApplicationContext(),"result : "+bis.read());*/

        /*byte[] b=new byte[5];
        try {
            bis.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bis.mark(0);
        byte[] bf=read(bis);
        Util.toast(getApplicationContext(),"result : "+new String(bf));*/


        short mShott=Short.MAX_VALUE;
        int mInt=Integer.MAX_VALUE;
        long mLong=Long.MAX_VALUE;
        double mDouble=Double.MAX_VALUE;
        String mString="thanh";
        byte[] mByte="thanh".getBytes();

        Parses parses=new Parses();
        parses.add(parses.getByte(mShott));
        parses.add(parses.getByte(mInt));
        parses.add(parses.getByte(mLong));
        parses.add(parses.getByte(mDouble));
        parses.add(parses.getByte(mString));
        parses.add(parses.getByte(mString));
        parses.add(parses.getByte(mByte));
        parses.Close();

        Converter converter=new Converter(parses.getBuffer());
        com.example.mylibrary.Util.messageDisplay("result :"+converter.byteToShort()+" +++ "+mShott);
        com.example.mylibrary.Util.messageDisplay("result :"+converter.byteToInterger()+" +++ "+mInt);
        com.example.mylibrary.Util.messageDisplay("result :"+converter.byteToLong()+" +++ "+mLong);
        com.example.mylibrary.Util.messageDisplay("result :"+converter.byteToDouble()+" +++ "+mDouble);
        com.example.mylibrary.Util.messageDisplay("result :"+converter.byteToString()+" +++ "+mString);
        Util.messageDisplay("result :"+new String(converter.byteToByte())+" +++ "+new String(mByte));

    }


}