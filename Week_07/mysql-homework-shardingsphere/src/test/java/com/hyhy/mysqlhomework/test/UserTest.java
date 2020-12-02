package com.hyhy.mysqlhomework.test;


import com.hyhy.mysqlhomework.Application;
import com.hyhy.mysqlhomework.entity.UserEntity;
import com.hyhy.mysqlhomework.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Author: hyhy
 * @Date: 2020/12/2 7:48 下午
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class UserTest {

    @Autowired
    private UserRepository repository;


    @Test
    public void userInsertTest(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(10L);
        userEntity.setName("hhhh");
        userEntity.setPwdHash("aaaaaaaaa");
        userEntity.setAddrsId(100L);
        repository.save(userEntity);
    }

    @Test
    public void userSelectTest(){

    }


}
