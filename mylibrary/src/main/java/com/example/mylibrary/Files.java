package com.example.mylibrary;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Files {

    public static byte[] readFile(File sourceLocation) {
        if (sourceLocation == null || !sourceLocation.exists()) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Read file error : file no exists");
            }
            return null;
        }
        ByteArrayOutputStream ous = null;
        InputStream ios = null;
        try {
            byte[] buffer = new byte[4096];
            ous = new ByteArrayOutputStream();
            ios = new FileInputStream(String.valueOf(sourceLocation));
            int read = 0;
            while ((read = ios.read(buffer)) != -1) {
                ous.write(buffer, 0, read);
            }
            return ous.toByteArray();
        } catch (FileNotFoundException e) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Read file error :" + e.getMessage());
            }
            return null;

        } catch (IOException e) {

            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Read file error :" + e.getMessage());
            }
            return null;
        } finally {
            try {
                if (ous != null)
                    ous.close();
                if (ios != null)
                    ios.close();
            } catch (IOException e) {
                if (BuildConfig.DEBUG) {
                    Util.messageDisplay("Read file error :" + e.getMessage());
                }
                return null;
            }
        }
    }

    public static boolean wirteFile(File sourceLocation, byte[] buffer) {
        if (buffer == null || sourceLocation == null) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Write file error : message null");
            }
            return false;
        }

        File parent = new File(sourceLocation.getParent());
        if (!parent.exists()) {
            parent.mkdirs();
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Write file error : Create parent file " + parent);
            }
        }

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(String.valueOf(sourceLocation));
            fos.write(buffer);
            fos.close();
            return true;
        } catch (IOException e) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Write file error :" + e.getMessage());
            }
            return false;
        }
    }

    public static boolean delete(File sourceLocation) {
        if (sourceLocation == null || !sourceLocation.exists()) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("delete file error : path no exists ");
            }
            return false;
        }
        if (sourceLocation.isDirectory()) {
            for (File f : sourceLocation.listFiles()) {
                delete(f);
            }
            return true;
        } else {
            sourceLocation.delete();
            return true;
        }
    }


    public static boolean copy(File sourceLocation, File targetLocation) {
        if(sourceLocation==null||targetLocation==null||!sourceLocation.exists()){
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Coppy file error : file no exists");
            }
            return false;
        }
        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdirs();
            }
            String[] children = sourceLocation.list();
            for (int i = 0; i < children.length; i++) {
                copy(new File(sourceLocation, children[i]), new File(targetLocation, children[i]));
            }
            return true;
        } else {
            return copyFile(sourceLocation, targetLocation);
        }
    }

    public static boolean copyFile(File sourceLocation, File targetLocation) {

        InputStream in = null;
        OutputStream out=null;
        try {
            in = new FileInputStream(sourceLocation);
            out = new FileOutputStream(targetLocation);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();

            return true;
        } catch (FileNotFoundException e) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Coppy file error :"+e.getMessage());
            }
            return false;
        } catch (IOException e) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Coppy file error :"+e.getMessage());
            }
            return false;
        }
    }

    public static boolean zip(File[] sourceLocation, File targetLocation) {

        if(sourceLocation==null||targetLocation==null){
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Zip file error : file no exists");
            }
            return false;
        }
        try {
            BufferedInputStream origin = null;
            FileOutputStream dest = new FileOutputStream(targetLocation);
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            byte data[] = new byte[1024];

            for (int i = 0; i < sourceLocation.length; i++) {

                if(sourceLocation[i]==null||!sourceLocation[i].exists()){
                    if (BuildConfig.DEBUG) {
                        Util.messageDisplay("Zip file error : file no exists");
                    }
                    return false;
                }
                if(sourceLocation[i].isFile())
                {
                    FileInputStream fi = new FileInputStream(sourceLocation[i]);
                    origin = new BufferedInputStream(fi, 1024);
                    ZipEntry entry = new ZipEntry(sourceLocation[i].getName());

                    out.putNextEntry(entry);
                    int count;
                    while ((count = origin.read(data, 0, 1024)) != -1) {
                        out.write(data, 0, count);
                    }

                }

                origin.close();

            }
            out.close();
            return true;

        } catch (Exception e) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Zip file error :"+e.getMessage());
            }
            return false;
        }
    }



    public static boolean zipDir(File zipFileName, File dir){

        File dirObj = new File(String.valueOf(dir));
        ZipOutputStream out = null;
        try {

            out = new ZipOutputStream(new FileOutputStream(zipFileName));
            System.out.println("Creating : " + zipFileName);
            addDir(dirObj, out);
            out.close();
            return true;

        } catch (FileNotFoundException e) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Zip file error :"+e.getMessage());
            }
            return false;
        } catch (IOException e) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Zip file error :"+e.getMessage());
            }
            return false;
        }
    }

    static void addDir(File dirObj, ZipOutputStream out)  {
        File[] files = dirObj.listFiles();
        byte[] tmpBuf = new byte[1024];

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                addDir(files[i], out);
                continue;
            }
            FileInputStream in = null;
            try {
                in = new FileInputStream(files[i].getAbsolutePath());
                System.out.println(" Adding: " + files[i].getAbsolutePath());
                out.putNextEntry(new ZipEntry(files[i].getAbsolutePath()));
                int len;
                while ((len = in.read(tmpBuf)) > 0) {
                    out.write(tmpBuf, 0, len);
                }
                out.closeEntry();
                in.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }




}
