package com.hyhy.distributed_transaction.entity;


import lombok.Data;

import java.util.Date;

@Data
public class TOrder {

  private long id;
  private long userId;
  private long amount;
  private Date orderGeneratedTime;
  private Integer status;
  private long productIds;
}
