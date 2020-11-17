package com.hyhy.concurrent.exercise.waitnotify;


/**
 * 两线程打印0~100 分别奇偶
 * wait notify
 */
public class OddEvenPrint100v2 implements Runnable {

    private static final Object lock = new Object();
    private static Integer cnt = 0;


    public static void main(String[] args) {
        OddEvenPrint100v2 v2 = new OddEvenPrint100v2();
        new Thread(v2, "偶").start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(v2, "奇").start();
    }

    public void run() {
        while (cnt <= 100) {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + ":" + cnt);
                cnt++;
                lock.notify();
                if (cnt <= 100) {
                    try {
                        // 任务没结束 让出锁 并休眠
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
