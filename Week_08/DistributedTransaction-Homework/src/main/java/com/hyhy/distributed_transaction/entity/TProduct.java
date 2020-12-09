package com.hyhy.distributed_transaction.entity;


import lombok.Data;

import java.util.Date;

@Data
public class TProduct {

    private long id;
    private long productPrice;
    private String productImages;
    private String productInfo;
    private String productTitle;
    private Integer productDel;
    private Integer productShelf;
    private Date productShelfTime;
}
