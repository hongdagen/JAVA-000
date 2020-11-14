package com.hyhy.spring.fx.test;

import com.hyhy.spring.fx.Beans.DotaHeroInitConfig;
import com.hyhy.spring.fx.POJO.DotaHeroInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;

/**
 *  注解的方式
 */

//@RunWith(SpringJUnit4ClassRunner.class)
public class AnnotationTest {

    @Test
    public void annotationTest(){
        ApplicationContext context = new AnnotationConfigApplicationContext(DotaHeroInitConfig.class);
        DotaHeroInfo info = context.getBean("initDotaHeroBean", DotaHeroInfo.class);
        info.setName("invoker");
        System.out.println(info.toString());
    }
}
