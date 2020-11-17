package com.hyhy.concurrent.exercise.waitnotify;


/**
 * 两线程打印0~100 分别奇偶
 */
public class OddEvenPrint100v1 {

    private static final Object lock = new Object();
    private static Integer cnt = 0;


    public static void main(String[] args) {
        Thread odd = new Thread(new Runnable() {
            public void run() {
                while (cnt < 100) {
                    synchronized (lock) {
                        if ((cnt & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + cnt);
                            cnt++;
                        }
                    }
                }
            }
        }, "奇");

        Thread even = new Thread(new Runnable() {
            public void run() {
                while (cnt < 100) {
                    synchronized (lock) {
                        if ((cnt & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + cnt);
                            cnt++;
                        }
                    }
                }
            }
        }, "偶");

        even.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        odd.start();
    }

}
