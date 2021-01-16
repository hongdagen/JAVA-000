package com.hyhy.mq.custom.core;

/**
 * @Author: hyhy
 * @Date: 2021/1/16 6:55 下午
 */
public final class KmqBroker<T> {
    public static final int CAPACITY = 10000;
    KMockQueue<T> kqueue = null;


    public void createTopic(String name){
        kqueue = new KMockQueue<>();
        kqueue.createTopic(name);
    }



    public KmqProducer createProducer() {
        return new KmqProducer(this);
    }

    public KmqConsumer createConsumer(String topic, String consumerName,Boolean isAck) {
        kqueue.addConsumer(topic, consumerName,isAck);
        return new KmqConsumer(this, consumerName);
    }


}
