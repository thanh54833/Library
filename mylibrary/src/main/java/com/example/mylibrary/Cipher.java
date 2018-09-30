package com.example.mylibrary;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cipher {

    public static byte[] md5(byte[] buffer) {

        if(buffer==null)
        {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Cipher md5 error : buffer no exists");
            }
            return null;
        }
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(buffer);
            byte messageDigest[] = digest.digest();
            return messageDigest;
        }catch (NoSuchAlgorithmException e) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Cipher md5 error :"+e.getMessage());
            }
            return null;
        }
    }


    public static byte[] sha(byte[] buffer) {

        if(buffer==null)
        {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Cipher md5 error : buffer no exists");
            }
            return null;
        }
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
            digest.update(buffer);
            byte messageDigest[] = digest.digest();
            return messageDigest;
        }catch (NoSuchAlgorithmException e) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Cipher md5 error :"+e.getMessage());
            }
            return null;
        }
    }


    public static String hexToString(byte[] messageDigest){
        StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            }
        return hexString.toString();
    }

}
