package com.example.mytliasaop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 测试各种通知类型的用法 (Around, Before, After, AfterReturning, AfterThrowing)
 * 涉及到的点包括: 通知类型, 通知函数参数, PointCut 切入点提取, 连接点参数获取与使用
 */

//@Aspect
//@Component
@Slf4j
public class NoticeTypeAsp {
    @Pointcut("execution(* com.example.mytliasaop.controller.DeptController.getDeptById(..))")
    public void allDeptCut(){}

    @Around("allDeptCut()")
    public Object aroundNoticeFunA(ProceedingJoinPoint point) throws Throwable {
        log.info("Around Notice: enter ... ...");
        Object res = point.proceed();
        log.info("Around Notice: after point.proceed(), before return ... ...");
        return res;
    }

    @Before("allDeptCut()")
    public void beforeNotice() {
        log.info("Before Notice: execute ... ...");
    }

    @After("allDeptCut()")
    public void afterNotice() {
        log.info("After Notice: execute ... ...");
    }

    @AfterReturning("allDeptCut()")
    public void afterReturnNotice(){
        log.info("After returning Notice: execute ... ...");
    }

    @AfterThrowing("allDeptCut()")
    public void afterThrowNotice() {
        log.info("After Throw Notice: enter ... ...");
    }

    @Before("allDeptCut()")
    public void beforeWithArgs(JoinPoint point){
        log.info("Before Notice with join-point args: enter ... ...");
        log.info("Before Notice with join-point args: 方法名 {}", point.getSignature());
        log.info("Before Notice with join-point args: 方法参数 {}}", point.getArgs());
        log.info("Before Notice with join-point args: 类名 {}", point.getTarget().getClass().getName());
    }
}
