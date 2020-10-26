package com.hyhy.httpclient.demo;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * okhttp 实现客户端 并请求 http://localhost:8801
 */
public class OkHttpClientDemo {

    public void getReq(String url) {
        OkHttpClient client = new OkHttpClient();

        Request req = new Request.Builder()
                .url(url)
                .build();
        Response resp = null;
        try {
            //能连接到netty服务器， 但是大概几十秒后报 read timeout
            resp = client.newCall(req).execute();
            System.out.println("resp:"+resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (resp != null && resp.isSuccessful()) {
            // TODO
            System.out.println("success");
        } else {
            // TODO
            System.out.println("failed");
            System.out.println(resp);
        }
    }

    public static void main(String[] args) {
        OkHttpClientDemo client = new OkHttpClientDemo();
        client.getReq("http://127.0.0.1:8801");
    }
}
