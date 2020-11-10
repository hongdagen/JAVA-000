package com.hyhy.concurrent.exercise.join;


/**
 * join版
 */
public class Join {


    public static void main(String[] args) throws InterruptedException {
        SubJoin subJoin = new SubJoin();
        Thread thread = new Thread(subJoin);
        thread.start();
        thread.join();
        System.out.println("主线程退出");
    }
}
