package com.example.thanh.library;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mylibrary.Files;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.main);

        File extStore = Environment.getExternalStorageDirectory();
        File fileread=new java.io.File(extStore+"/test.txt");
        File filewrite=new java.io.File(extStore+"/thanh/thanh.txt");

        // read file
        //textView.append(text);
        //textView.setText(null);

        //Toast.makeText(this,"result :"+Files.wirteFile(filewrite,Files.readFile(fileread)),Toast.LENGTH_SHORT).show();
        //if(Files.readFile(fileread)!=null) {
        //    textView.append(new String(Files.readFile(fileread)));
        //}

        Toast.makeText(getApplicationContext(),"result :"+Files.delete(fileread),Toast.LENGTH_SHORT).show();



    }
}
