package com.example.mylibrary;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Files {

    public static byte[] readFile(File path)  {
        if(!path.exists()||path==null){
            if(BuildConfig.DEBUG){
                Util.messageDisplay("Read file error : file no exists");
            }
            return null;
        }
        ByteArrayOutputStream ous = null;
        InputStream ios = null;
        try {
            byte[] buffer = new byte[4096];
            ous = new ByteArrayOutputStream();
            ios = new FileInputStream(String.valueOf(path));
            int read = 0;
            while ((read = ios.read(buffer)) != -1) {
                ous.write(buffer, 0, read);
            }
            return ous.toByteArray();
        } catch (FileNotFoundException e) {
            if(BuildConfig.DEBUG){
                Util.messageDisplay("Read file error :"+e.getMessage());
            }
            return null;

        } catch (IOException e) {

            if(BuildConfig.DEBUG){
                Util.messageDisplay("Read file error :"+e.getMessage());
            }
            return null;
        }
        finally {
            try {
                if (ous != null)
                    ous.close();
                if (ios != null)
                    ios.close();
            }
            catch (IOException e) {
                if(BuildConfig.DEBUG){
                    Util.messageDisplay("Read file error :"+e.getMessage());
                }
                return null;
            }
        }
    }

    public static boolean wirteFile(File path, byte[] buffer){
        File parent=new File(path.getParent());
        if(!parent.exists())
        {
            parent.mkdirs();
            if(BuildConfig.DEBUG){
                Util.messageDisplay("Write file error : Create parent file "+parent);
            }
        }
        if(buffer==null||path==null){
            if(BuildConfig.DEBUG){
                Util.messageDisplay("Write file error : message null");
            }
            return false;
        }
        FileOutputStream fos=null;
        try {
            fos = new FileOutputStream(String.valueOf(path));
            fos.write(buffer);
            fos.close();
            return true;
        } catch (IOException e) {
            if(BuildConfig.DEBUG){
                Util.messageDisplay("Write file error :"+e.getMessage());
            }
            return false;
        }
    }

    public static boolean delete(File path){
        if(!path.exists()||path==null){
            if(BuildConfig.DEBUG){
                Util.messageDisplay("delete file error : path no exists ");
            }
            return false;
        }
        if (path.isDirectory()) {
            for (File f : path.listFiles()) {
                delete(f);
            }
            return true;
        } else {
            path.delete();
            return true;
        }
    }








}
