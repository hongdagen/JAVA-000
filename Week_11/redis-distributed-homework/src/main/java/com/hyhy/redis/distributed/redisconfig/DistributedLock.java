package com.hyhy.redis.distributed.redisconfig;

/**
 * @Author: hyhy
 * @Date: 2021/1/2 5:04 下午
 */
public interface DistributedLock {
    String acquire();
    boolean release(String identify);
}
