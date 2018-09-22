package com.example.thanh.library;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        File fileread=new File(extStore+"/test.txt");
        File filewrite=new File(extStore+"/thanh/thanh.txt");

        File filecopy=new File(extStore+"/test/thanh123");
        File filecopy1=new File(extStore+"/test1");

        File[] filezip=new File[3];

        filezip[0]=new File(extStore+"/text1.doc");
        filezip[1]=new File(extStore+"/hello.txt");
        filezip[2]=new File(extStore+"/test");

        // read file
        //textView.append(text);
        //textView.setText(null);
        //Toast.makeText(this,"result :"+Files.wirteFile(null,Files.readFile(null)),Toast.LENGTH_SHORT).show();
        //if(Files.readFile(fileread)!=null) {
        //    textView.append(new String(Files.readFile(fileread)));
        //}
        //Toast.makeText(getApplicationContext(),"result :"+Files.delete(fileread),Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(),"result :"+Files.copy(filecopy,filecopy1),Toast.LENGTH_SHORT).show();

        //Toast.makeText(getApplicationContext(),"result :"+Files.zip(filezip,new File(extStore+"/zip")),Toast.LENGTH_SHORT).show();

        Toast.makeText(getApplicationContext(),"result :"+Files.zipDir(new File(extStore+"/test"),new File(extStore+"/zip")),Toast.LENGTH_SHORT).show();





    }
}
