package com.hyhy.redis.distributed.redisconfig;

import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.UUID;

/**
 * @Author: hyhy
 * @Date: 2021/1/2 4:51 下午
 */
public class RedisTool implements DistributedLock {
    private static final String LOCK_SUCCESS = "OK";
    private static final Long RELEASE_SUCCESS = 1L;
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    private Jedis jedis;

    private String lockKey;

    // 超时时间
    int expireTime = 10 * 1000;

    // 锁等待时间
    int acquireTimeout = 1000;

    public RedisTool(Jedis jedis, String lockKey, int expireTime, int acquireTimeout) {
        this.jedis = jedis;
        this.lockKey = lockKey;
        this.expireTime = expireTime;
        this.acquireTimeout = acquireTimeout;
    }

    public RedisTool(Jedis jedis, String lockKey) {
        this.jedis = jedis;
        this.lockKey = lockKey;
    }

    public RedisTool(Jedis jedis, String lockKey, int acquireTimeout) {
        this.jedis = jedis;
        this.lockKey = lockKey;
        this.acquireTimeout = acquireTimeout;
    }


    @Override
    public String acquire() {
        try {
            // 获取锁的超时时间，超过这个时间则放弃获取锁
            long end = System.currentTimeMillis() + acquireTimeout;
            // 随机生成一个value
            String requireToken = UUID.randomUUID().toString();
            while (System.currentTimeMillis() < end) {
                String result = jedis.set(lockKey, requireToken, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
                if (LOCK_SUCCESS.equals(result)) {
                    return requireToken;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        } catch (Exception e) {
            System.out.println("acquire lock due to error:" + e);
        }

        return null;
    }

    @Override
    public boolean release(String identify) {
        if (identify == null) {
            return false;
        }

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = new Object();
        try {
            result = jedis.eval(script, Collections.singletonList(lockKey),
                    Collections.singletonList(identify));
            if (RELEASE_SUCCESS.equals(result)) {
                System.out.println("release lock success, requestToken:" + identify);
                return true;
            }
        } catch (Exception e) {
            System.out.println("release lock due to error:" + e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

        System.out.println("release lock failed, requestToken:" + identify + " result:" + result);
        return false;
    }
}
