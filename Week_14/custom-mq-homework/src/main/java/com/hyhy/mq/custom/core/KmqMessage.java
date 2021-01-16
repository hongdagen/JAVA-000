package com.hyhy.mq.custom.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

/**
 * @Author: hyhy
 * @Date: 2021/1/16 6:54 下午
 */
@AllArgsConstructor
@Data
public class KmqMessage<T> {

    private HashMap<String, Object> headers;
    private T body;
}
