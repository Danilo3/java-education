package com.koryakin.edu;

public class Main {

    public static void main(String[] args) {

        byte b1 = 0;

        b1 = (byte)(~b1);

        byte b2 = (byte)0x01;

        System.out.println(Integer.toHexString(Byte.toUnsignedInt(b1)));
        System.out.println(Integer.decode("0x01"));
        System.out.println(Byte.decode("0x01"));
        System.out.println(Byte.toUnsignedLong(b2));

    }
}
