package com.example.mylibrary;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadUrl {

    public static int proscess;
    public static void urlConnection(String url, File file){

        if(url==null||file==null){
            if(BuildConfig.DEBUG){
                Util.messageDisplay("Download UrlConnection error : Url or file by null");
            }
        }
        try {

            URL urls = new URL(url);
            String fileName = url.substring( url.lastIndexOf('/')+1, url.length());

            URLConnection connection = urls.openConnection();
            connection.connect();

            int length=connection.getContentLength();

            InputStream input = new BufferedInputStream(connection.getInputStream());

            OutputStream output = new FileOutputStream(new File(file,fileName));
            byte data[] = new byte[1024];
            int total=0;
            int count;
            while ((count = input.read(data)) != -1) {
                total+=count;
                proscess =Integer.valueOf(total/length);
                output.write(data, 0, count);
            }
            output.flush();
            output.close();
            input.close();
            if(BuildConfig.DEBUG){
                Util.messageDisplay("Download done.. :");
            }
        } catch (Exception e) {
            if(BuildConfig.DEBUG){
                Util.messageDisplay("Download error :"+e.getMessage());
            }
        }
    }

    public static void socket(){

    }

}
