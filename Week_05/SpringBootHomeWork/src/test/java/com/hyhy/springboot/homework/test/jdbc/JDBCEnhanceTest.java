package com.hyhy.springboot.homework.test.jdbc;


import com.hyhy.springboot.homework.Application;
import com.hyhy.springboot.homework.POJO.DotaHeroInfo;
import com.hyhy.springboot.homework.jdbc.JDBCEnhance;
import com.hyhy.springboot.homework.jdbc.JDBCOri;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class JDBCEnhanceTest {

    @Autowired
    private JDBCEnhance enhance;


    @Test
    public void testJDBCOriInsertBulk() {
        enhance.connect();
        List<DotaHeroInfo> infos = new ArrayList<>();
        DotaHeroInfo info1 = new DotaHeroInfo("zhangsan1");
        infos.add(info1);

        DotaHeroInfo info2 = new DotaHeroInfo("zhangsan2");
        infos.add(info2);

        DotaHeroInfo info3 = new DotaHeroInfo("zhangsan3");;
        infos.add(info3);

        enhance.insertBulk(infos);
    }

}