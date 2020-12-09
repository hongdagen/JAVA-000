package com.hyhy.distributed_transaction;

import com.hyhy.distributed_transaction.entity.TUser;
import com.hyhy.distributed_transaction.entity.TUserAddrs;
import com.hyhy.distributed_transaction.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Author: hyhy
 * @Date: 2020/12/9 10:18
 */


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void userServiceTest1(){
        TUser user = new TUser(2,"hyhy2","13888888888","mima","email",new Date(),123);

        TUserAddrs addr = new TUserAddrs(2, 2, "dizhi1", new Date());

        userService.insertUserInfo(user,addr);
    }


    @Test
    public void userServiceTest2(){
        // 输入错误样例 id:2 已存在
        // 事物提交失败:com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry '2' for key 'PRIMARY'
        TUser user = new TUser(2,"hyhy2","13888888888","mima","email",new Date(),123);

        TUserAddrs addr = new TUserAddrs(2, 2, "dizhi1", new Date());

        userService.insertUserInfo(user,addr);
    }
}
