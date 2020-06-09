package com.example.redisdemo.thread;

class VolatileDemo extends Thread{
    private volatile Boolean flag = true;
    @Override
    public void run() {
        System.out.println("线程开始");
        while (flag){

        }
        System.out.println("线程结束");
    }
    public Boolean setFlag(Boolean flag){
        return this.flag = flag;
    }
}

public class VolatileTest {


    public static void main(String[] args) throws InterruptedException {
        VolatileDemo t1 = new VolatileDemo();
        t1.start();
        Thread.sleep(3000);
        t1.setFlag(false);
        System.out.println("结束");
    }
}

