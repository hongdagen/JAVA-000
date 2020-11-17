package com.hyhy.concurrent.exercise.atom;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAplplTest {

    private static AtomicInteger cnt = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    cnt.incrementAndGet();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    cnt.incrementAndGet();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(cnt.get());
    }
}
