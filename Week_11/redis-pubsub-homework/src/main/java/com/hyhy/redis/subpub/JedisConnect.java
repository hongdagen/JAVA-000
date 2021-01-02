package com.hyhy.redis.subpub;

import redis.clients.jedis.Jedis;

/**
 * @Author: hyhy
 * @Date: 2021/1/2 5:31 下午
 */
public class JedisConnect {

    private String ip = "127.0.0.1";
    private int port = 6379;

    public JedisConnect(){

    }

    public JedisConnect(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public Jedis conn() {
        return new Jedis(ip, port);
    }
}
