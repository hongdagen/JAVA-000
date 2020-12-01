package com.hyhy.mysql.repository;

import com.hyhy.mysql.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductEntityMapper {


    int insert(ProductEntity record);
}