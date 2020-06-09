package com.example.redisdemo.pattern.single;

/**
 * 双重检查
 */
public class Singleton6 {
    private volatile static Singleton6 instance;
    static int a = 1;
    private Singleton6(){

    }

    public static Singleton6 getInstance() {
        if(instance == null){
            synchronized (Singleton6.class){
                if (instance == null){
                    return new Singleton6();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (this){
                        a=a+1;

                        Thread.sleep(5000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(runnable).start();
        Thread.sleep(500);
        System.out.println(a);
    }
}
