package com.local.admin.config;

import com.local.admin.service.util.DBContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

@Aspect
@Component
public class DynamicDataSourceAspect {

    @Pointcut("execution(* com.local.admin.service.impl.*.*(..))")
    public void pointCut() {

    }

    @Around("pointCut()")
    public void beforeAdvice(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        Transactional annotation = targetMethod.getAnnotation(Transactional.class);
        if (annotation != null) {
            DBContext.set("mark");
        } else {
            DBContext.set("test");
        }
        pjp.proceed();

    }


}
