package com.example.redisdemo.threadcoreknowiedge.createthread.uncaughtexecption;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 自定义异常，用于捕获子线程中异常信息
 */
public class MyUncatchException implements Thread.UncaughtExceptionHandler {
    private String name;

    public MyUncatchException(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger log = Logger.getAnonymousLogger();
        log.log(Level.WARNING,"线程一场，终止啦"+t.getName());
    }
}
