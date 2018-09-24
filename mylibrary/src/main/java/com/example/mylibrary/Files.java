package com.example.mylibrary;

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
        if (sourceLocation == null || targetLocation == null || !sourceLocation.exists()) {
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
        OutputStream out = null;
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
                Util.messageDisplay("Coppy file error :" + e.getMessage());
            }
            return false;
        } catch (IOException e) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Coppy file error :" + e.getMessage());
            }
            return false;
        }
    }


    public static boolean zip(File[] srcFolder, File destZipFile) {
        if(srcFolder==null||destZipFile==null){
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Zip file error : file no exists" );
            }
            return false;
        }
        ZipOutputStream zip = null;
        FileOutputStream fileWriter = null;
        try {
            fileWriter = new FileOutputStream(destZipFile);
            zip = new ZipOutputStream(fileWriter);
            for (File folder : srcFolder) {

                if(folder==null||!folder.exists())
                {
                    if (BuildConfig.DEBUG) {
                        Util.messageDisplay("Zip file error : file no exists" );
                    }
                    continue;
                }

                if (folder.isDirectory()) {
                    zipDirectory("", folder, zip);
                } else {
                    zipFile("",folder,zip);
                }

            }
            zip.flush();
            zip.close();
            return true;
        } catch (FileNotFoundException e) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Zip file error : "+e.getMessage() );
            }
            return false;
        } catch (IOException e) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Zip file error : "+e.getMessage() );
            }
            return false;
        } catch (Exception e) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Zip file error : "+e.getMessage() );
            }
            return false;
        }
    }

    private static void zipDirectory(String path, File srcFolder, ZipOutputStream zip) throws Exception {
        for (String fileName : srcFolder.list()) {
            if (path.equals("")) {
                addFileToZip(srcFolder.getName(), new File(srcFolder + "/" + fileName), zip);
            } else {
                addFileToZip(path + "/" + srcFolder.getName(), new File(srcFolder + "/" + fileName), zip);
            }
        }
    }

    private static void zipFile(String path, File srcFile, ZipOutputStream zip) throws Exception {
        byte[] buf = new byte[1024];
        int len;
        FileInputStream in = new FileInputStream(srcFile);
        if(path.equals("")){
            zip.putNextEntry(new ZipEntry(srcFile.getName()));
        }
        else {
            zip.putNextEntry(new ZipEntry(path + "/" + srcFile.getName()));
        }
        while ((len = in.read(buf)) > 0) {
            zip.write(buf, 0, len);
        }
    }

    private static void addFileToZip(String path, File srcFile, ZipOutputStream zip) throws Exception {
        if (srcFile.isDirectory()) {
            zipDirectory(path, srcFile, zip);
        } else {
            zipFile(path,srcFile,zip);
        }
    }




}
