package io.kimmking.dubbo.demo.api;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: hyhy
 * @Date: 2020/12/16 10:29
 */
@Data
public class AccountDTO implements Serializable {

    private static final long serialVersionUID = 7223470850578998427L;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 扣款金额
     */
    private BigDecimal amount;

    /**
     * 单位
     */
    private String unit;

}
