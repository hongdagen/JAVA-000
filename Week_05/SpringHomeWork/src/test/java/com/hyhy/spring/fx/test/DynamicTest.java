package com.hyhy.spring.fx.test;

import com.hyhy.spring.fx.Beans.DotaHeroInitConfig;
import com.hyhy.spring.fx.Beans.DotaHeroInitConfig2;
import com.hyhy.spring.fx.POJO.DotaHeroInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


public class DynamicTest {


    @Test
    public void dynamicTest() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext();
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(DotaHeroInfo.class);
        // 注册
        beanFactory.registerBeanDefinition("dotaheroinit2", beanDefinitionBuilder.getBeanDefinition());
        System.out.println("   context.getBeanDefinitionNames() ===>> " + String.join(",", context.getBeanDefinitionNames()));
        context.refresh();
        DotaHeroInfo info = (DotaHeroInfo) context.getBean("dotaheroinit2");
        info.setName("doom");
        System.out.println(info.toString());
    }

}
