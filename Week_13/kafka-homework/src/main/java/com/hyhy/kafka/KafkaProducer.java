package com.hyhy.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @Author: hyhy
 * @Date: 2021/1/12 9:12 下午
 */
@Component
public class KafkaProducer {


    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(String topic, Object obj){
        ListenableFuture<SendResult<String,Object>> future = kafkaTemplate.send(topic, obj);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("消息发送失败"+throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> sendResult) {
                System.out.println("发送结果:"+sendResult.toString());
            }
        });
    }
}
