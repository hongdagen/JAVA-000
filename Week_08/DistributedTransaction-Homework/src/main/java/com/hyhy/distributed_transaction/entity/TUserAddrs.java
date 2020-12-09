package com.hyhy.distributed_transaction.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor
public class TUserAddrs {

  private long id;
  private long userId;
  private String addr;
  private Date lastUpdateTime;

  public TUserAddrs(){

  }
}
