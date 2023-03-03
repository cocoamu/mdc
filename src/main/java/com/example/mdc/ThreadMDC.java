package com.example.mdc;

public class ThreadMDC {

    public static void main(String[] args) {
        new BizHandle("F0000").start();
        new BizHandle("F9999").start();
    }
}
