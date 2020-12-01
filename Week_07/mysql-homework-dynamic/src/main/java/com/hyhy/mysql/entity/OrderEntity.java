package com.hyhy.mysql.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OrderEntity {
    private Long orderId;

    private Long userId;

    private Long amount;

    private Date orderGeneratedTime;

    private Integer status;

    private Long productIds;
}