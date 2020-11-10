package com.hyhy.concurrent.exercise.countdownlatch;

import com.hyhy.concurrent.exercise.BaseMethod;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch cdl = new CountDownLatch(1);
        new Thread(new Runnable() {
            public void run() {
                Thread.currentThread().setName("countdownlatch的新线程");
                System.out.println(BaseMethod.print(Thread.currentThread().getName()));
                cdl.countDown();
            }
        }).start();
        cdl.await();
        System.out.println("主线程结束");
    }
}
