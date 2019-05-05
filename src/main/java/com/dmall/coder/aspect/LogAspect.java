package com.dmall.coder.aspect;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * Description: 切面类
 *
 * @Author Guangcai.xu
 * @Date 2019/1/29 13:22
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    /**
     * 定义切入点
     */
//    @Pointcut("@annotation(com.dmall.coder.aspect.annotation.LogAction)")
//    public void pointCut() {
//    }

    @Pointcut("execution(public * com.dmall.coder.aspect..*.*(..))")
    public void pointCut(){}

//    @Before("pointCut() && @annotation(logAction)")
//    public void printParamInfo(JoinPoint joinPoint, LogAction logAction) {
//        log.info(logAction.description());
//        //获取目标方法的参数信息
//        Object[] obj = joinPoint.getArgs();
//        //AOP代理类的信息
//        joinPoint.getThis();
//        //代理的目标对象
//        joinPoint.getTarget();
//        //用的最多 通知的签名
//        Signature signature = joinPoint.getSignature();
//        //代理的是哪一个方法
//        log.info("代理的是哪一个方法" + signature.getName());
//        //AOP代理类的名字
//        log.info("AOP代理类的名字" + signature.getDeclaringTypeName());
//        //AOP代理类的类（class）信息
//        signature.getDeclaringType();
//        //获取RequestAttributes
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        //从获取RequestAttributes中获取HttpServletRequest的信息
//        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
//        //如果要获取Session信息的话，可以这样写：
//        //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
//        //获取请求参数
//        Enumeration<String> enumeration = request.getParameterNames();
//        Map<String, String> parameterMap = Maps.newHashMap();
//        while (enumeration.hasMoreElements()) {
//            String parameter = enumeration.nextElement();
//            parameterMap.put(parameter, request.getParameter(parameter));
//        }
//        String str = JSON.toJSONString(parameterMap);
//        if (obj.length > 0) {
//            log.info("请求的参数信息为：" + str);
//        }
//    }

    @Before("pointCut()")
    public void printParamInfo(JoinPoint joinPoint) {
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        //AOP代理类的信息
        joinPoint.getThis();
        //代理的目标对象
        joinPoint.getTarget();
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        log.info("代理的是哪一个方法" + signature.getName());
        //AOP代理类的名字
        log.info("AOP代理类的名字" + signature.getDeclaringTypeName());
        //AOP代理类的类（class）信息
        signature.getDeclaringType();
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //如果要获取Session信息的话，可以这样写：
        //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        //获取请求参数
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String, String> parameterMap = Maps.newHashMap();
        while (enumeration.hasMoreElements()) {
            String parameter = enumeration.nextElement();
            parameterMap.put(parameter, request.getParameter(parameter));
        }
        String str = JSON.toJSONString(parameterMap);
        if (obj.length > 0) {
            log.info("请求的参数信息为：" + str);
        }
    }

    @AfterReturning(returning = "ret", pointcut = "pointCut()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        log.info("RESPONSE : " + ret);
    }

    @Around(value = "pointCut()")
    public Object aroundInfo(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("环绕通知的目标方法名：" + proceedingJoinPoint.getSignature().getName());
        try {
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @After("pointCut()")
    public void afterAdvice(){
        log.info("最终的后置通知");
    }

}