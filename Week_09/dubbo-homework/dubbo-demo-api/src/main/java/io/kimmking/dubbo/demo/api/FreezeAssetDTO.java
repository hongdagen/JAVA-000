package io.kimmking.dubbo.demo.api;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: hyhy
 * @Date: 2020/12/16 13:01
 */

@Data
public class FreezeAssetDTO implements Serializable {

    private static final long serialVersionUID = 8229355519336565493L;

    private String userId;
    private Long accountId;
    private BigDecimal amount;
}
