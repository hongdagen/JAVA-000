package com.hyhy.mysql.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserEntity {
    private Long userId;

    private String name;

    private Integer mobile;

    private String pwdHash;

    private String email;

    private Date regTime;

    private Long addrsId;

}