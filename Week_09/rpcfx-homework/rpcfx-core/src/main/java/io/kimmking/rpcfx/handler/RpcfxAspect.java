package io.kimmking.rpcfx.handler;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author: hyhy
 * @Date: 2020/12/15 9:41
 */

@Aspect
@Component
public class RpcfxAspect {


    @Pointcut("execution(public * io.kimmking.rpcfx.client.Rpcfx.create(..))")
    public void rpcfxAspect(){

    }
    /**
     * @description  在连接点执行之前执行的通知
     */
    @Before("rpcfxAspect()")
    public void doBefore(){
        System.out.println("在连接点执行之前执行的通知");
    }

    /**
     * @description  在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    @After("rpcfxAspect()")
    public void doAfter(){
        System.out.println("在连接点执行之后执行的通知（返回通知和异常通知的异常）");
    }

    /**
     * @description  在连接点执行之后执行的通知（返回通知）
     */
    @AfterReturning("rpcfxAspect()")
    public void doAfterReturning(){
        System.out.println("在连接点执行之后执行的通知（返回通知）");
    }

    /**
     * @description  在连接点执行之后执行的通知（异常通知）
     */
    @AfterThrowing("rpcfxAspect()")
    public void doAfterThrowing(){
        System.out.println("在连接点执行之后执行的通知（异常通知）");
    }

}
