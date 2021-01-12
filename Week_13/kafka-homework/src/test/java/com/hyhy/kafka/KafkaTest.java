package com.hyhy.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: hyhy
 * @Date: 2021/1/12 9:21 下午
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class KafkaTest {
    @Autowired
    private KafkaProducer producer;

    @Test
    public void test(){
        producer.sendMessage("docker-kafka-topic", "testestest");
    }

}
