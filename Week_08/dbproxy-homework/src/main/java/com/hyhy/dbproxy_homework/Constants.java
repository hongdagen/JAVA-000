package com.hyhy.dbproxy_homework;

public class Constants {

    public static final String url = "jdbc:mysql://localhost:3307/orderdb?characterEncoding=UTF-8&useSSL=false";
    public static final String username = "root";
    public static final String password = "root";

    public static final String INSERT_BASE = "INSERT INTO `ordertable` (`id`,`user_id`, `amount`, `order_generated_time`, `status`, `product_ids`) VALUES\n" +
            "(%d, %d, %d, '%s', %d, %d);";
    public static final String DELETE_BASE = "DELETE FROM `ordertable` WHERE id = %d";
    public static final String UPDATE_BASE = "UPDATE `ordertable` SET user_id=%d,amount=%d,order_generated_time='%s',status=%d,product_ids=%d WHERE id=%d";
    public static final String QUERY_ALL_BASE = "SELECT * FROM ordertable";
}
