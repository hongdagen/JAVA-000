package com.hyhy.redis.subpub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * @Author: hyhy
 * @Date: 2021/1/2 5:31 下午
 */
public class subscriber {

    public static void main(String[] args) {
        JedisPubSub jedisPubSub = new JedisPubSub(){
            @Override
            public void onMessage(String channel, String message) {
                System.out.println("onMessage"+"---"+channel + ":" + message);
            }

            @Override
            public void onSubscribe(String channel, int subscribedChannels) {
                System.out.println("onSubscribe"+"---"+channel + ":" + subscribedChannels);
            }
        };

        JedisConnect jedisConnect = new JedisConnect();
        Jedis c = jedisConnect.conn();
        c.subscribe(jedisPubSub,"c1");
    }
}
