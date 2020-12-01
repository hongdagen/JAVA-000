package com.hyhy.mysql.repository;

import com.hyhy.mysql.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserEntityMapper {
    int insert(UserEntity record);
}