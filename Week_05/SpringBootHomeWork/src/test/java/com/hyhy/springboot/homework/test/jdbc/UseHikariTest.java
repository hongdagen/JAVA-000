package com.hyhy.springboot.homework.test.jdbc;


import com.hyhy.springboot.homework.Application;
import com.hyhy.springboot.homework.POJO.DotaHeroInfo;
import com.hyhy.springboot.homework.jdbc.JDBCOri;
import com.hyhy.springboot.homework.jdbc.UseHikari;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class UseHikariTest {

    @Autowired
    private UseHikari hikari;


    @Test
    public void testJDBCOriInsert() {
        DotaHeroInfo info = new DotaHeroInfo("invoker2");
        System.out.println(hikari.insert(info));
    }

    @Test
    public void testJDBCOrDelete() {
        System.out.println(hikari.delete(3));
    }

    @Test
    public void testJDBCOriUpdate() {
        DotaHeroInfo info = new DotaHeroInfo("invoker33333");
        System.out.println(hikari.update(2, info));
    }


    @Test
    public void testJDBCOrQuery() {
        List<DotaHeroInfo> infos = hikari.query();
        for (DotaHeroInfo info : infos) {
            System.out.println(info.toString());
        }
    }
}
