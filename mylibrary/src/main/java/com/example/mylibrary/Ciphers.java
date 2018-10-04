package com.example.mylibrary;

import android.annotation.SuppressLint;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Ciphers {



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


    public static class AES {

        public static byte[] encrypt(byte[] buffer, byte[] secret)
        {

            if(buffer==null||secret==null)
            {
                if(BuildConfig.DEBUG){
                    Util.messageDisplay("Cipper AES  encrypt error : buffer and secret by null");
                }
                return null;
            }
            try
            {
                SecretKeySpec secretKey = new SecretKeySpec(secret, "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                return cipher.doFinal(buffer);
            }
            catch (Exception e)
            {
                if(BuildConfig.DEBUG){
                    Util.messageDisplay("Cipper AES encrypt error : "+e.getMessage());
                }
                return null;
            }

        }
        public static byte[] decrypt(byte[] buffer, byte[] secret)
        {

            if(buffer==null||secret==null)
            {
                if(BuildConfig.DEBUG){
                    Util.messageDisplay("Cipper AES  decrypt error : buffer and secret by null");
                }
                return null;
            }
            try
            {
                SecretKeySpec secretKey = new SecretKeySpec(secret, "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                return cipher.doFinal(buffer);
            }
            catch (Exception e)
            {
                if(BuildConfig.DEBUG){
                    Util.messageDisplay("Cipper AES decrypt error : "+e.getMessage());
                }
                return null;
            }
        }
    }

    public static class DES {

        public static byte[] encrypt(byte[] buffer, byte[] secret)
        {

            if(buffer==null||secret==null)
            {
                if(BuildConfig.DEBUG){
                    Util.messageDisplay("Cipper AES  encrypt error : buffer and secret by null");
                }
                return null;
            }
            try
            {
                SecretKeySpec secretKey = new SecretKeySpec(secret, "DES");
                Cipher cipher = Cipher.getInstance("DES");
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                return cipher.doFinal(buffer);
            }
            catch (Exception e)
            {
                if(BuildConfig.DEBUG){
                    Util.messageDisplay("Cipper AES encrypt error : "+e.getMessage());
                }
                return null;
            }

        }
        public static byte[] decrypt(byte[] buffer, byte[] secret)
        {

            if(buffer==null||secret==null)
            {
                if(BuildConfig.DEBUG){
                    Util.messageDisplay("Cipper AES  decrypt error : buffer and secret by null");
                }
                return null;
            }
            try
            {
                SecretKeySpec secretKey = new SecretKeySpec(secret, "DES");
                Cipher cipher = Cipher.getInstance("DES");
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                return cipher.doFinal(buffer);
            }
            catch (Exception e)
            {
                if(BuildConfig.DEBUG){
                    Util.messageDisplay("Cipper AES decrypt error : "+e.getMessage());
                }
                return null;
            }
        }
    }

    public static byte[] NOT(byte[] buffer){
        if(buffer==null) {
            if(BuildConfig.DEBUG){
                Util.messageDisplay("Cipper NOT  error : buffer by null");
            }
        }
        byte[] empty = new byte[buffer.length];
        for (int i = 0; i<empty.length; i++) {
            empty[i]= (byte)~buffer[i];
        }
        return empty;
    }

    public static byte[] XOR(byte[] buffer){
        if(buffer==null) {
            if(BuildConfig.DEBUG){
                Util.messageDisplay("Cipper NOT  error : buffer by null");
            }
        }
        byte[] empty = new byte[buffer.length];
        for (int i = 0; i<empty.length; i++) {
            empty[i]= (byte)~buffer[i];
        }
        return empty;
    }

    /*
     public static byte[] encrypt(byte[] input, int cipherKey) {
        checkCipherNotZero(cipherKey);
        byte[] output = input.clone();

        for (int i = 0; i <= output.length - BYTES_PER_INT; ++i) {
            writeInt(output, i, readInt(output, i) + cipherKey);
        }

        return output;
    }*/

    


    public static String hexToString(byte[] messageDigest){
        StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            }
        return hexString.toString();
    }

}
