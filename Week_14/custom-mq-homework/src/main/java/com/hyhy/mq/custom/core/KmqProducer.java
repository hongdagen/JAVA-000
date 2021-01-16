package com.hyhy.mq.custom.core;

/**
 * @Author: hyhy
 * @Date: 2021/1/16 6:57 下午
 */
public class KmqProducer {
    private KmqBroker broker;

    public KmqProducer(KmqBroker broker) {
        this.broker = broker;
    }

    public void send(String topic, KmqMessage message) {
        broker.kqueue.add(topic, message);
    }
}
