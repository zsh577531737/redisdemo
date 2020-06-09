package com.example.redisdemo.threadcoreknowiedge.createthread.knowage;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {
    private static BlockingQueue blockingQueue = new LinkedBlockingQueue(10);

    public static void main(String[] args) {
        Timer timer = new Timer();
        Random random = new Random();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("开始塞值");
                blockingQueue.offer(random.nextInt(101));
                System.out.println("塞值");
            }
        },0,200);
        new Thread(() -> {
            while(true){
                try {
                    Thread.sleep(5000);
                    System.out.println("开始取值");
                    List<Integer> list = new LinkedList<>();
                    blockingQueue.drainTo(list);  //drainTo()将队列中的值全部从队列中移除，并赋值给对应集合
                    list.forEach(System.out::println);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
