package com.example.redisdemo.pattern.single;

public class Hungry {
    private static final Hungry instance = new Hungry();

    private Hungry() {
    }

    public Hungry getInstance(){
        return instance;
    }
}
