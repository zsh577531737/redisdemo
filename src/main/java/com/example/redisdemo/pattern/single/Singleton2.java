package com.example.redisdemo.pattern.single;

public class Singleton2 {
    private static final Singleton2 INSTANCE;

    private Singleton2() {
    }

    static {
        INSTANCE = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}
