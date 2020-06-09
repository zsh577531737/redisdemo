package com.example.redisdemo.threadcoreknowiedge.createthread;

public class ThreadStyle extends Thread{
    @Override
    public void run() {
        System.out.println("使用Thread实现");
    }

    public static void main(String[] args) {
        ThreadStyle threadStyle = new ThreadStyle();
        threadStyle.start();
    }
}
