package com.example.demo;

import io.swagger.annotations.Api;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * AOP方法级
 *
 * @author huxu
 * @create 2017-08-05 16:14
 **/

@Aspect // FOR AOP
@Order(-99) // 控制多个Aspect的执行顺序，越小越先执行
@Component
public class TestAspect {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Before("@annotation(test)")// 拦截被TestAnnotation注解的方法；如果你需要拦截指定package指定规则名称的方法，可以使用表达式execution(...)
    public void beforeTest(JoinPoint point, TestAnnotation test) throws Throwable {
        LOG.info("beforeTest:{}",test.name());
    }

    @After("@annotation(test)")
    public void afterTest(JoinPoint point, TestAnnotation test) {
        LOG.info("afterTest:{}",test.name());
    }

}
