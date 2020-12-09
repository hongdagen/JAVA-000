package com.hyhy.distributed_transaction.service;

import com.hyhy.distributed_transaction.entity.TUser;
import com.hyhy.distributed_transaction.entity.TUserAddrs;
import com.hyhy.distributed_transaction.repository.Handler;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @Author: hyhy
 * @Date: 2020/12/9 10:07
 */
@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Handler dao;


    public void insertUserInfo(TUser user, TUserAddrs addr) {
        jdbcTemplate.execute((ConnectionCallback<Object>) connection ->{
            connection.setAutoCommit(false);

            try{
                long userId = dao.insertUser(connection, user);
                dao.insertUserAddrs(connection,addr,userId);
                connection.commit();
                System.out.println("事物提交成功");
            }catch (final SQLException e){
                connection.rollback();
                System.out.println("事物提交失败:"+e);
            }
            return connection;
        });
    }
}
