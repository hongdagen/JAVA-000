package com.hyhy.springboot.homework.jdbc;

public class Constants {

    public static final String url = "jdbc:mysql://localhost:3306/dota_db_test?characterEncoding=UTF-8&useSSL=false";
    public static final String username = "root";
    public static final String password = "root";

    public static final String INSERT_BASE = "INSERT INTO `t_dota_hero_info` (`NAME`, `STRENGTH`, `AGILITY`, `INTELLIGENCE`, `IS_CARRY`) VALUES\n" +
            "('%s', %d, %d, %d, %d);";
    public static final String DELETE_BASE = "DELETE FROM `t_dota_hero_info` WHERE id = %d";
    public static final String UPDATE_BASE = "UPDATE `t_dota_hero_info` SET name='%s',strength=%d,agility=%d,intelligence=%d,is_carry=%d WHERE id=%d";
    public static final String QUERY_ALL_BASE = "SELECT * FROM t_dota_hero_info";


    public static final String INSERT_ENHANCE_BASE = "INSERT INTO `t_dota_hero_info` (`NAME`, `STRENGTH`, `AGILITY`, `INTELLIGENCE`, `IS_CARRY`) VALUES (?,?,?,?,?)";
    public static final String DELETE_ENHANCE_BASE = "DELETE FROM `t_dota_hero_info` WHERE id =?";
    public static final String UPDATE_ENHANCE_BASE = "UPDATE `t_dota_hero_info` SET name=?,strength=?,agility=?,intelligence=?,is_carry=? WHERE id=?";
    public static final String QUERY_ALL_ENHANCE_BASE = "SELECT * FROM t_dota_hero_info";
}
