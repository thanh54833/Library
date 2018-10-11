package com.example.mylibrary;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class Converter {

    private ByteArrayInputStream bInput = null;

    public Converter(byte[] buffer) {

        bInput = new ByteArrayInputStream(buffer);

    }

    public short byteToShort() {
        byte[] buffer = new byte[2];
        try {
            while (bInput.read(buffer) < buffer.length) {

            }
        } catch (IOException e) {

            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Byte to short error :" + e.getMessage());
            }
        } finally {
            if (bInput != null) {
                bInput.mark(0);
            } else {
                if (BuildConfig.DEBUG) {
                    Util.messageDisplay("Byte to short error : bInput byte null");
                }
            }
        }
        return ByteBuffer.wrap(buffer).getShort();
    }

    public int byteToInterger() {
        byte[] buffer = new byte[4];
        try {
            while (bInput.read(buffer) < buffer.length) {
            }
        } catch (IOException e) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Byte to int error :" + e.getMessage());
            }
        } finally {
            if (bInput != null) {
                bInput.mark(0);
            } else {
                if (BuildConfig.DEBUG) {
                    Util.messageDisplay("Byte to int error : bInput byte null");
                }
            }
        }
        return ByteBuffer.wrap(buffer).getInt();
    }

    public long byteToLong() {
        byte[] buffer = new byte[8];
        try {
            while (bInput.read(buffer) < buffer.length) {
            }
        } catch (IOException e) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Byte to long error :" + e.getMessage());
            }
        } finally {
            if (bInput != null) {
                bInput.mark(0);
            } else {
                if (BuildConfig.DEBUG) {
                    Util.messageDisplay("Byte to long error : bInput byte null");
                }
            }
        }
        return ByteBuffer.wrap(buffer).getLong();
    }

    public double byteToDouble() {
        byte[] buffer = new byte[8];
        try {
            while (bInput.read(buffer) < buffer.length) {
            }
        } catch (IOException e) {
            if (BuildConfig.DEBUG) {
                if (BuildConfig.DEBUG) {
                    Util.messageDisplay("Byte to double error :" + e.getMessage());
                }
            }
        } finally {
            if (bInput != null) {
                bInput.mark(0);
            } else {
                if (BuildConfig.DEBUG) {
                    Util.messageDisplay("Byte to double error : bInput byte null");
                }
            }
        }
        return ByteBuffer.wrap(buffer).getDouble();
    }

    public String byteToString() {
        int length = byteToInterger();
        byte[] buffer = new byte[length];
        try {
            while (bInput.read(buffer) < buffer.length) {
            }
        } catch (IOException e) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Byte to string error :" + e.getMessage());
            }
        } finally {
            if (bInput != null) {
                bInput.mark(0);
            } else {
                if (BuildConfig.DEBUG) {
                    Util.messageDisplay("Byte to string error : bInput byte null");
                }
            }
        }
        return new String(buffer);
    }

    public byte[] byteToByte() {
        int length = byteToInterger();
        byte[] buffer = new byte[length];
        try {
            while (bInput.read(buffer) < buffer.length) {
            }
        } catch (IOException e) {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Byte to byte error :" + e.getMessage());
            }
        } finally {
            if (bInput != null) {
                bInput.mark(0);
            } else {
                if (BuildConfig.DEBUG) {
                    Util.messageDisplay("Byte to byte error : bInput byte null");
                }
            }
        }
        return buffer;
    }


    public void Close() {
        if (bInput != null) {
            try {
                bInput.close();
            } catch (IOException e) {
                if (BuildConfig.DEBUG) {
                    Util.messageDisplay("Converter error : " + e.getMessage());
                }
            }
        } else {
            if (BuildConfig.DEBUG) {
                Util.messageDisplay("Converter error : bInput byte null");
            }
        }
    }


}
