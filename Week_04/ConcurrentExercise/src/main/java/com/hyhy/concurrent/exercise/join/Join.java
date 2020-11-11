package com.hyhy.concurrent.exercise.join;


/**
 * join版
 */
public class Join {

    private static Integer value;

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法


        Thread thread = new Thread(new Runnable() {
            public void run() {
                value = sum();
            }
        });
        thread.start();
        thread.join();

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
