package com.hyhy.concurrent.exercise.catchException;

public class MyUncaughtExceptionHandlerTest  implements Runnable{
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        MyUncaughtExceptionHandlerTest test = new MyUncaughtExceptionHandlerTest();

        Thread t1 = new Thread(test, "t1");
        t1.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        t1.start();

        Thread t2 = new Thread(test, "t2");
        t2.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        t2.start();

    }
}
