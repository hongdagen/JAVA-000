package com.hyhy.dbproxy_homework;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class JDBCOriTest {

    @Autowired
    private JDBCOri ori;


    @Test
    public void testJDBCOriInsert() {
        TOrderEntity info = new TOrderEntity(100L, 1000L, 10000L, new Date(), 1, 1000L);
        ori.connect();
        System.out.println(ori.insert(info));
    }

    @Test
    public void testJDBCOrDelete() {
        ori.connect();
        System.out.println(ori.delete(100));
    }

    @Test
    public void testJDBCOriUpdate() {
        TOrderEntity info = new TOrderEntity(100L, 2222L, 2222L, new Date(), 1, 2222L);
        ori.connect();
        System.out.println(ori.update(100, info));
    }


    @Test
    public void testJDBCOrQuery() {
        ori.connect();
        List<TOrderEntity> infos = ori.query();
        for (TOrderEntity info : infos) {
            System.out.println(info.toString());
        }
    }
}
