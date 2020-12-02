package com.hyhy.mysqlhomework.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: hyhy
 * @Date: 2020/12/2 7:44 下午
 */

@Data
@Entity
@Table(name = "t_user")
public class UserEntity {
    @Id
    private Long id;
    private String name;
    private Integer mobile;
    private String pwdHash;
    private String email;
    private Date regTime;
    private Long addrsId;
}
