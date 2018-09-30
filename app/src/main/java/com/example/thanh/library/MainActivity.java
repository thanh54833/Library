package com.example.thanh.library;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mylibrary.Cipher;
import com.example.mylibrary.Files;
import com.example.mylibrary.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

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

        //File[] filezip=new File[1];
        //filezip[0]=new File(extStore+"/text1.doc");
        //filezip[1]=new File(extStore+"/hello.txt");
        //filezip[0]=new File(extStore+"/test");
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
        //Toast.makeText(getApplicationContext(),"result :"+Files.zip(filezip,new File(extStore+"/zip")),Toast.LENGTH_SHORT).show();

        /*File [] array=new File[3];
        array[0]=new File(extStore+"/test");
        array[1]=new File(extStore+"/data");
        array[2]=new File(extStore+"/thanh.txt");

        Files.zip(array,new File(extStore+"/zip.zip"));

        if(BuildConfig.DEBUG){
            Util.messageDisplay("++ true"); }

        if(BuildConfig.DEBUG){
           if(Files.unZip(new File(extStore+"/zip.zip"),new File(extStore+"/zip123"))){
               Toast.makeText(getApplicationContext(),"true !",Toast.LENGTH_SHORT).show();
           }
           else
           {
               Toast.makeText(getApplicationContext(),"false !",Toast.LENGTH_SHORT).show();
           }
        }*/

        /*File dir=Environment.getExternalStorageDirectory();
        for(File file:Files.finder(dir,"thanh",".txt")){
            textView.append("+++"+String.valueOf(file));
        }*/

        /*File dir=Environment.getExternalStorageDirectory();
        textView.setText(null);

        for(File file:Files.find(dir,"text",".doc"))
        {
            textView.append(String.valueOf(file)+"\n");
        }*/

        File dir=new File(Environment.getExternalStorageDirectory()+"/text1.doc");

        byte[] buffer="thanh".getBytes();

        textView.append("result :"+Cipher.hexToString(Cipher.sha(buffer)));




    }
}
