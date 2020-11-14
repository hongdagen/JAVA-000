package com.hyhy.spring.fx.test;


import com.hyhy.spring.fx.POJO.DotaHeroInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * XML方式
 */

public class XMLTest {

    @Test
    public void XmlTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DotaHeroInfo linaInfo = (DotaHeroInfo) context.getBean("linaInfo");
        System.out.println(linaInfo.toString());
    }
}
