package com.example.thanh.library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mylibrary.Parses;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

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

        Parses parses=new Parses();

        parses.add("thanh".getBytes());
        parses.add("khong".getBytes());
        parses.add("pham".getBytes());

        parses.Close();

        byte[] buffer=parses.getBuffer();

        ByteArrayInputStream bis=new ByteArrayInputStream(buffer);
        bis.skip(4);

        byte[] bf=read(bis);
        Toast.makeText(getApplicationContext())


        }

    public byte[] read(ByteArrayInputStream bais) {
        byte[] array = new byte[bais.available()];
        try {
            bais.read(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }


}