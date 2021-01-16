package com.hyhy.mq.custom.core;

import lombok.SneakyThrows;

/**
 * @Author: hyhy
 * @Date: 2021/1/16 6:56 下午
 */
public class KmqConsumer<T> {

    private final KmqBroker broker;

    private String consumerName;


    public KmqConsumer(KmqBroker broker, String consumerName) {
        this.broker = broker;
        this.consumerName = consumerName;
    }

    public void subscribe(String topic, Boolean isAck) {
        broker.kqueue.addConsumer(topic,consumerName, isAck);
    }

    @SneakyThrows
    public KmqMessage<T> poll(String topic, long timeout) {
        Thread.sleep(timeout);
        return broker.kqueue.poll(topic, consumerName);
    }
}
