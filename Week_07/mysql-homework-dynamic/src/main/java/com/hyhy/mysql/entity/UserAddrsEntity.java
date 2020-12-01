package com.hyhy.mysql.entity;

import lombok.Data;

import java.util.Date;
@Data
public class UserAddrsEntity {
    private Long id;

    private Long userId;

    private String addr;

    private Date lastUpdateTime;
}