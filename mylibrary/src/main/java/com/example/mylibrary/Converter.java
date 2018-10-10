package com.example.mylibrary;

import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;

public class Converter {

    private ByteArrayInputStream bInput=null;

    public Converter(byte[] buffer){
        bInput=new ByteArrayInputStream(buffer);
    }
    public  short byteToShort(byte[] value) {

        return ByteBuffer.wrap(value).getShort();
    }
    public  int byteToInterger(byte[] value) {

        return ByteBuffer.wrap(value).getInt();
    }
    public  long byteToLong(byte[] value) {

        return ByteBuffer.wrap(value).getLong();
    }
    public static double byteToDouble(byte[] value) {

        return ByteBuffer.wrap(value).getDouble();
    }
    public  String byteToString(byte[] value) {
        int length=byteToInterger(value);
        byte[] buffer=new byte[value.length-4];
        for(int i = 0; i<length; i++ ){
            buffer[i]=value[i+4];
        }
        return new String(buffer);
    }
    public  byte[] byteToByte(byte[] value) {
        int length=byteToInterger(value);
        byte[] buffer=new byte[value.length-4];
        for(int i = 0; i<length; i++ ){
            buffer[i]=value[i+4];
        }
        return buffer;
    }



}
