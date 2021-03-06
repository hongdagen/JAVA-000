package com.hyhy.concurrent.exercise.countdownlatch;


import java.util.concurrent.CountDownLatch;

public class Main {

    private static Integer value;


    public static void main(String[] args) throws Exception {
        final CountDownLatch cdl = new CountDownLatch(1);
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        Main main = new Main();

        new Thread(new Runnable() {
            public void run() {
                sum();
                cdl.countDown();
            }
        }).start();

        cdl.await();
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + value);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

    private static int sum() {
        value = fibo(6);
        return value;
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}
