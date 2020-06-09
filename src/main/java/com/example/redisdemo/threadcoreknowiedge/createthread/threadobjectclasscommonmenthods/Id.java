package com.example.redisdemo.threadcoreknowiedge.createthread.threadobjectclasscommonmenthods;

public class Id {
    private static int i;
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println(thread.getId());
    }
    public static int get(){
         i++;
         return i;
    }
}
