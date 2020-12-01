package com.hyhy.mysql.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ProductEntity {
    private Long productId;

    private Long productPrice;

    private String productImages;

    private String productInfo;

    private String productTitle;

    private Integer productDel;

    private Integer productShelf;

    private Date productShelfTime;


}