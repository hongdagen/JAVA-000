package com.hyhy.mysql.repository;

import com.hyhy.mysql.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderEntityMapper {

    int insert(OrderEntity record);

}