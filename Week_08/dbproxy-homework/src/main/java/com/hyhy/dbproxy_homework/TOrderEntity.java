package com.hyhy.dbproxy_homework;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @Author: hyhy
 * @Date: 2020/12/6 7:53 下午
 */

@Data
@AllArgsConstructor
public class TOrderEntity {
    private Long id;
    private Long userId;
    private Long amount;
    private Date orderGeneratedTime;
    private Integer status;
    private Long productIds;
}
