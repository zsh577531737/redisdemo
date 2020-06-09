package com.example.redisdemo.threadcoreknowiedge.createthread.threadobjectclasscommonmenthods;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Test {
    private static BlockingQueue<Integer> queue= new LinkedBlockingQueue<Integer>(10);
    private static Object object = new Object();
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService product = Executors.newScheduledThreadPool(1);
        Random random = new Random();
        product.scheduleAtFixedRate(() -> {
            int value = random.nextInt(101);
            try{
                queue.offer(value);  //offer()方法就是网队列的尾部设置值
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }, 0, 100, TimeUnit.MILLISECONDS);  //每100毫秒执行线程


        new Thread(() -> {
            while(true){
                try {
                    Thread.sleep(2000);
                    System.out.println("开始取值");
                    List<Integer> list = new LinkedList<>();
                    queue.drainTo(list);  //drainTo()将队列中的值全部从队列中移除，并赋值给对应集合
                    list.forEach(System.out::println);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
