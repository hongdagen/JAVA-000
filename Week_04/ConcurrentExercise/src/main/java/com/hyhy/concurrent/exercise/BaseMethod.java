package com.hyhy.concurrent.exercise;

public class BaseMethod {

    public static String print(String threadName) {
        return String.format("我是%s打印的", threadName);
    }

}
