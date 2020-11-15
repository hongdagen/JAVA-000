package com.hyhy.springboot.homework.test.jdbc;


import com.hyhy.springboot.homework.Application;
import com.hyhy.springboot.homework.POJO.DotaHeroInfo;
import com.hyhy.springboot.homework.jdbc.JDBCOri;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class JDBCOriTest {

    @Autowired
    private JDBCOri ori;


    @Test
    public void testJDBCOriInsert() {
        DotaHeroInfo info = new DotaHeroInfo("invoker2");
        ori.connect();
        System.out.println(ori.insert(info));
    }

    @Test
    public void testJDBCOrDelete() {
        ori.connect();
        System.out.println(ori.delete(3));
    }

    @Test
    public void testJDBCOriUpdate() {
        DotaHeroInfo info = new DotaHeroInfo("invoker33333");
        ori.connect();
        System.out.println(ori.update(2, info));
    }


    @Test
    public void testJDBCOrQuery() {
        ori.connect();
        List<DotaHeroInfo> infos = ori.query();
        for (DotaHeroInfo info : infos) {
            System.out.println(info.toString());
        }
    }
}
