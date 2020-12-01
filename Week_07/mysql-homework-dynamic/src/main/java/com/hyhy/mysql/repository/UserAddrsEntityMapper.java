package com.hyhy.mysql.repository;

import com.hyhy.mysql.entity.UserAddrsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserAddrsEntityMapper {
    int insert(UserAddrsEntity record);
}