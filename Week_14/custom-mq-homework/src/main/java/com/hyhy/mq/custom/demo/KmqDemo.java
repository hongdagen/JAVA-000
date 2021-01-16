package com.hyhy.mq.custom.demo;

import com.hyhy.mq.custom.core.KmqBroker;
import com.hyhy.mq.custom.core.KmqConsumer;
import com.hyhy.mq.custom.core.KmqMessage;
import com.hyhy.mq.custom.core.KmqProducer;
import lombok.SneakyThrows;

import java.util.Random;

/**
 * @Author: hyhy
 * @Date: 2021/1/16 7:06 下午
 */
public class KmqDemo {

    @SneakyThrows
    public static void main(String[] args) {

        String topic = "kk.test";
        KmqBroker broker = new KmqBroker();
        broker.createTopic(topic);


        KmqConsumer consumer1 = broker.createConsumer(topic, "A", true);
        KmqConsumer consumer2 = broker.createConsumer(topic, "B", false);

        new Thread(() -> {
            for (int j = 0; j < 100; j++) {
                KmqMessage<String> message1 = consumer1.poll(topic, 100);
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                KmqMessage<String> message2 = consumer2.poll(topic, 100);
            }
        }).start();


        KmqProducer producer = broker.createProducer();
        for (int i = 0; i < 1000; i++) {
            producer.send(topic, new KmqMessage(null, String.valueOf(i)));
        }
        Thread.sleep(100000);
    }
}
