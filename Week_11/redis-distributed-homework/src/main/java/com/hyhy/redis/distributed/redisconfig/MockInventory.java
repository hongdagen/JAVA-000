package com.hyhy.redis.distributed.redisconfig;

import redis.clients.jedis.Jedis;

/**
 * @Author: hyhy
 * @Date: 2021/1/2 5:14 下午
 */
public class MockInventory {
    private static int n = 500;

    public static void reduce() {
        System.out.println(--n);
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            RedisTool lock = null;
            String unLockIdentify = null;

            try {
                Jedis conn = new Jedis("127.0.0.1", 6379);
                lock = new RedisTool(conn, "test");
                unLockIdentify = lock.acquire();
                System.out.println(Thread.currentThread().getName() + "正在运行");
                reduce();
            } finally {
                if (lock != null) {
                    lock.release(unLockIdentify);
                }
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
