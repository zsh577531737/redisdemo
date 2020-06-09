package com.example.redisdemo.threadcoreknowiedge.createthread.wrongways;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 错误理解：使用定时器可以创建线程
 */
public class DemoTimmer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },1000,1000);
    }
}
