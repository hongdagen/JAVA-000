package com.hyhy.concurrent.exercise.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreMethod {
    private static Integer value;

    public static void main(String[] args) throws InterruptedException {

        final Semaphore semaphore = new Semaphore(1);
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法


        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                value = sum();
                semaphore.release();
            }
        });
        thread.start();

        semaphore.acquire();
        semaphore.release();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + value);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

    private static int sum() {
        return fibo(5);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}
