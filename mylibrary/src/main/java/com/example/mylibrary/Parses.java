package com.example.mylibrary;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class Parses {

    private ByteArrayOutputStream bos = new ByteArrayOutputStream();

    public byte[] getByte(short value) {


        return ByteBuffer.allocate(2).putShort(value).array();
    }

    public byte[] getByte(int value) {

        return ByteBuffer.allocate(4).putInt(value).array();
    }

    public byte[] getByte(long value) {


        return ByteBuffer.allocate(8).putLong(value).array();
    }

    public byte[] getByte(double value) {

        return ByteBuffer.allocate(8).putDouble(value).array();
    }

    public byte[] getByte(String value) {
        byte[] buffer = value.getBytes();
        int length = buffer.length;
        return ByteBuffer.allocate(buffer.length + 4).putInt(length).put(buffer).array();
    }

    public byte[] getByte(byte[] value) {
        int length = value.length;
        return ByteBuffer.allocate(value.length + 4).putInt(length).put(value).array();
    }

    public boolean add(byte[] buffer) {
        try {
            bos.write(buffer);
            return true;
        } catch (IOException e) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Parser error:" + e.getMessage());
            }
            return false;
        }
    }

    public byte[] getBuffer() {
        if (bos != null) {
            return bos.toByteArray();
        } else {
            return null;
        }
    }

    public boolean Close() {
        try {
            bos.flush();
            bos.close();
            return true;
        } catch (IOException e) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Parser error :" + e.getMessage());
            }
            return false;
        }
    }
}
