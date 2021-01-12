package com.hyhy.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author: hyhy
 * @Date: 2021/1/12 9:14 下午
 */
@Component
public class KafkaConsumer {
    @KafkaListener(topics = {"docker-kafka-topic"})
    public void consume(String message){
        System.out.println("receive msg "+ message);
    }
}
