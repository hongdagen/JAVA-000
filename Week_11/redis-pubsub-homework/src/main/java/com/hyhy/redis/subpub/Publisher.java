package com.hyhy.redis.subpub;

import redis.clients.jedis.Jedis;

/**
 * @Author: hyhy
 * @Date: 2021/1/2 5:31 下午
 */
public class Publisher {



    public static void main(String[] args) {
        JedisConnect jedisConnect = new JedisConnect();
        Jedis c = jedisConnect.conn();
        Long countSubscribe = c.publish("c1", "hyhyh");
        System.out.println("发布成功，订阅数量:"+ countSubscribe);
    }
}
