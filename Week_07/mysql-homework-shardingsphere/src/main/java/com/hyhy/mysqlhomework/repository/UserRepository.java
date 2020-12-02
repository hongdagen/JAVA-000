package com.hyhy.mysqlhomework.repository;

import com.hyhy.mysqlhomework.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: hyhy
 * @Date: 2020/12/2 7:46 下午
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
