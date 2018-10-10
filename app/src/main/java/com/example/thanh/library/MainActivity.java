package com.example.thanh.library;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mylibrary.Ciphers;
import com.example.mylibrary.DownloadUrl;
import com.example.mylibrary.Files;
import com.example.mylibrary.Parses;
import com.example.mylibrary.Util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/*
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


       /* File dir=new File(Environment.getExternalStorageDirectory()+"/thanhthanh.txt");
        /*byte[] buffer="thanh".getBytes();
        textView.append("result :"+Ciphers.hexToString(Ciphers.sha(buffer)));*/

//textView.append(new String(Ciphers.DES.decrypt(Ciphers.DES.encrypt(Files.readFile(dir),"11111111".getBytes()),"11111111".getBytes())));


//textView.append(new String(Files.readFile(dir)));
       /* byte[] test="thanh".getBytes();
        //textView.append("result : "+new String(Ciphers.XOR(Ciphers.XOR(test,"thanh".getBytes()),"thanh".getBytes())));
        //textView.append("result :"+new String(Ciphers.Shift.decrypt(Ciphers.Shift.encrypt(test,"thanh".getBytes()),"thanh".getBytes())));
        //byte t= Byte.parseByte("t");
        //textView.append("\n result :"+String.valueOf(t));


        //short s=Short.MAX_VALUE;

        //textView.append("result :"+Parses.byteToShort(Parses.shortToByte(s)));

        //int tests="pham hoai thanh".getBytes().length;

        //textView.append("result "+tests+" :"+Parses.byteToString(Parses.stringToByte("pham hoai thanh")));

        /*byte[] bb=ByteBuffer.allocate(8).putInt(100).put("thanh".getBytes()).array();
        byte[] b=new byte[4];
        byte[] b1=new byte[4];

        //int b1=ByteBuffer.wrap(bb).getInt();
        //textView.append("result :"+bb.length+"++"+b.length+"++");

        for(int i=0;i<4;i++){
            b[i]=bb[i];
        }

        for(int i=0;i<8&&i>3;i++){
            b1[i]=bb[i];
        }
        textView.append("result :"+b.length+"++"+Parses.byteToInterger(b)+"+++"+Parses.byteToInterger(b1));*/


        /*String cmd = "ls";
        Runtime run = Runtime.getRuntime();
        try {

            Process pr = run.exec(cmd);
           if(BuildConfig.DEBUG){
               Util.messageDisplay("running...");
           }

        } catch (IOException e) {
            if(BuildConfig.DEBUG){
                Util.messageDisplay("error..."+e.getMessage());
            }
        }*/


        /*textView.append("result :"+sudoForResult("ls"));

    }


    public static String sudoForResult(String...strings) {
        String res = "";
        DataOutputStream outputStream = null;
        InputStream response = null;
        try{
            Process su = Runtime.getRuntime().exec("su");
            outputStream = new DataOutputStream(su.getOutputStream());
            response = su.getInputStream();

            for (String s : strings) {
                outputStream.writeBytes(s+"\n");
                outputStream.flush();
            }

            outputStream.writeBytes("exit\n");
            outputStream.flush();
            try {
                su.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            res = readFully(response);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            Closer.closeSilently(outputStream, response);
        }
        return res;
    }
    public static String readFully(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = is.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        return baos.toString("UTF-8");
    }


    public static class Closer {
        // closeAll()
        public static void closeSilently(Object... xs) {
            // Note: on Android API levels prior to 19 Socket does not implement Closeable
            for (Object x : xs) {
                if (x != null) {
                    try {
                        //Log.d("closing: "+x);
                        if (x instanceof Closeable) {
                            ((Closeable)x).close();
                        } else if (x instanceof Socket) {
                            ((Socket)x).close();
                        } else if (x instanceof DatagramSocket) {
                            ((DatagramSocket)x).close();
                        } else {
                            //Log.d("cannot close: "+x);
                            throw new RuntimeException("cannot close "+x);
                        }
                    } catch (Throwable e) {
                        //Log.x(e);
                    }
                }
            }
        }
    }
}
*/


import android.view.View;
import android.widget.Button;

import android.app.Activity;

public class MainActivity extends Activity implements View.OnClickListener {

    private TextView textView;
    private Button button;
    private Handler mHandler;
    private static final int Message_Count_Down = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        /*String fileURL = "http://jdbc.postgresql.org/download/postgresql-9.2-1002.jdbc4.jar";
        File saveDir = new File(Environment.getExternalStorageDirectory(),"thanh.png");
        try {
            DownloadUrl.downloadFile(fileURL,saveDir);
        } catch (IOException ex) {
            ex.printStackTrace();
            Toast.makeText(getApplicationContext(),"false",Toast.LENGTH_SHORT).show();
        }*/

        String fileURL = "http://jdbc.postgresql.org/download/postgresql-9.2-1002.jdbc4.jar";
        File saveDir=new File(Environment.getExternalStorageDirectory(),"/thanh");

        //Toast.makeText(getApplicationContext(),"result :"+String.valueOf(file),Toast.LENGTH_SHORT).show();
        // String saveDir = "E:/Download";


        try {
            DownloadUrl.downloadFile(fileURL, String.valueOf(saveDir));
        } catch (IOException ex) {
            ex.printStackTrace();
            Toast.makeText(getApplicationContext(),"Exception :"+ ex.getMessage(),Toast.LENGTH_SHORT).show();
        }










    }


    public static void downloadFile(String fileURL, String saveDir)
            throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();

        if(com.example.mylibrary.BuildConfig.DEBUG){
            // Util.messageDisplay("Download url connection error : "+responseCode);
        }

        // always check HTTP response code first
        /*if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();

            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10,
                            disposition.length() - 1);
                }
            } else {
                // extracts file name from URL
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
                        fileURL.length());
            }

            System.out.println("Content-Type = " + contentType);
            System.out.println("Content-Disposition = " + disposition);
            System.out.println("Content-Length = " + contentLength);
            System.out.println("fileName = " + fileName);

            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;

            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);

            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();

            System.out.println("File downloaded");
        } else {
            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();*/
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
