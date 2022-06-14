package com.highcom.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class MyAdvice {
    //定义通用Aspect表达式，下面通知方法就可以引用此方法的规则了
    @Pointcut("execution(* com.highcom.service.imp.*.*(..))")
    private void anyMethod() {
    }

    @Before("anyMethod()")
    public void beforeMethod(JoinPoint joinpoint) {
        System.out.println("前置通知日志" + joinpoint.toString());
    }

    @After("anyMethod()")
    public void afterMethod(JoinPoint joinpoint) {
        System.out.println("后置通知日志" + joinpoint.toString());
    }

    @AfterReturning(pointcut = "anyMethod()", returning = "result")
    public void afterReturnning(JoinPoint joinpoint, Object result) {
        System.out.println("返回通知日志" + joinpoint.toString());
    }

    @AfterThrowing(pointcut = "anyMethod()", throwing = "ex")
    public void afterThrowing(JoinPoint joinpoint, Exception ex) {
        System.out.println("异常通知日志" + joinpoint.toString());
    }
}
