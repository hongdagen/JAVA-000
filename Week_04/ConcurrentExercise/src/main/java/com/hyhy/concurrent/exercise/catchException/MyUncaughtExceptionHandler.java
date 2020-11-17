package com.hyhy.concurrent.exercise.catchException;



public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{


    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("线程:"+t.getName()+"发生了异常:"+e);
    }
}
