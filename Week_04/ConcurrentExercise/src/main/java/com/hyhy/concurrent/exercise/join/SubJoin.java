package com.hyhy.concurrent.exercise.join;

import com.hyhy.concurrent.exercise.BaseMethod;

public class SubJoin implements Runnable {
    public void run() {
        Thread.currentThread().setName("新线程");
        System.out.println(BaseMethod.print(Thread.currentThread().getName()));
    }
}
