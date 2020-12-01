package com.hyhy.mysql.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: hyhy
 * @Date: 2020/12/1 9:21 下午
 */
@Aspect
@Component
public class DataSourceAOP {
    @Pointcut("!@annotation(com.hyhy.mysql.anno.Master) " +
                     "&& (execution(* com.hyhy.mysql.service..*.select*(..)) " +
                     "|| execution(* com.hyhy.mysql.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.hyhy.mysql.anno.Master) " +
            "|| execution(* com.hyhy.mysql.service..*.insert*(..)) " +
            "|| execution(* com.hyhy.mysql.service..*.add*(..)) " +
            "|| execution(* com.hyhy.mysql..*.update*(..)) " +
            "|| execution(* com.hyhy.mysql.service..*.edit*(..)) " +
            "|| execution(* com.hyhy.mysql.service..*.delete*(..)) " +
            "|| execution(* com.hyhy.mysql..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }
}
