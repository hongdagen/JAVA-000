package com.hyhy.mq.custom.core;


import java.util.*;

/**
 * @Author: hyhy
 * @Date: 2021/1/16 9:14 下午
 */
public class KMockQueue<T> {
    private Map<String, KTopic<T>> record;

    public KMockQueue() {
        record = new HashMap<>();
    }

    public void createTopic(String topic) {
        if (record.get(topic) != null) {
            System.out.println("topic已存在");
            return;
        }

        KTopic queue = new KTopic<>();
        queue.setTopicName(topic);
        queue.setQueue(new ArrayList<>());
        queue.setConsumersInfo(new HashMap<>());
        record.put(topic, queue);
    }


    public void addConsumer(String topic, String consumerName, boolean isAck) {
        KTopic<T> queue = record.get(topic);
        if (queue != null) {
            if (!queue.getConsumersInfo().containsKey(consumerName)) {
                queue.getConsumersInfo().put(consumerName, new KPosition(0, 0, 0, isAck));
            } else {
                System.out.printf("topic:%s， 已包含接收者：%s\n", topic, consumerName);
                return;
            }
        }

    }

    public Integer getCurPosition(String topic, String consumerName) {
        KTopic<T> queue = record.get(topic);
        if (queue != null) {
            if (queue.getTopicName().equals(topic)) {
                return queue.getConsumersInfo().get(consumerName).getPosition();
            }
        }
        return null;
    }

    public void setCurPosition(String topic, String consumerName, Integer position) {
        KTopic<T> queue = record.get(topic);
        if (queue != null) {
            if (queue.getTopicName().equals(topic)) {
                queue.getConsumersInfo().get(consumerName).setPosition(position);
                if (queue.getConsumersInfo().get(consumerName).getIsAck()) {
                    queue.getConsumersInfo().get(consumerName).setOriPosition(queue.getConsumersInfo().get(consumerName).getPosition());
                }
            }
        }
    }

    public void add(String topic, KmqMessage message) {
        KTopic<T> queue = record.get(topic);
        if (queue != null) {
            if (queue.getTopicName().equals(topic)) {
                queue.getQueue().add(message);
            }
        }
    }

    public KmqMessage<T> poll(String topic, String consumerName) {
        KTopic<T> queue = record.get(topic);
        if (queue != null) {
            if (queue.getTopicName().equals(topic)) {
                Integer po = getCurPosition(topic, consumerName);
                KmqMessage<T> msg = queue.getQueue().get(po);
                setCurPosition(topic, consumerName, ++po);
                System.out.printf("curConsumerName:%s, curPosition:%d, oriPosition:%d\n",
                        consumerName,
                        queue.getConsumersInfo().get(consumerName).getPosition(),
                        queue.getConsumersInfo().get(consumerName).getOriPosition()
                );
                return msg;
            }
        }
        return null;
    }
}
