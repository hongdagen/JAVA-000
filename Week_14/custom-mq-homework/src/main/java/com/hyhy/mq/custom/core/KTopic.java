package com.hyhy.mq.custom.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Author: hyhy
 * @Date: 2021/1/16 10:08 下午
 */

@Data
public class KTopic<T> {
    private String topicName;
    private List<KmqMessage<T>> queue;
    private Map<String, KPosition> consumersInfo;
}
