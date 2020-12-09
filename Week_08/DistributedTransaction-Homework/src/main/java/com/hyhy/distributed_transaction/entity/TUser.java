package com.hyhy.distributed_transaction.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class TUser {

  private long id;
  private String name;
  private String mobile;
  private String pwdHash;
  private String email;
  private Date regTime;
  private long addrsId;

  public TUser(){

  }
}
