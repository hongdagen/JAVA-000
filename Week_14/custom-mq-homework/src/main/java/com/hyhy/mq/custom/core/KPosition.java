package com.hyhy.mq.custom.core;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: hyhy
 * @Date: 2021/1/16 10:09 下午
 */
@Data
@AllArgsConstructor
public class KPosition {
    private Integer position;
    private Integer limit;
    private Integer oriPosition;
    private Boolean isAck;
}
