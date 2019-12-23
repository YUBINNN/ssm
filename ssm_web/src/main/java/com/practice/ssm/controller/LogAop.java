package com.practice.ssm.controller;

import com.practice.ssm.daomain.SysLog;
import com.practice.ssm.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private SysLogService sysLogService;

    private Date startTime;
    private Class executionCalss;
    private Method executionMethod;



    //获取类、方法、访问时间
    @Before("execution(* com.practice.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws Exception {

        startTime = new Date();
        executionCalss = jp.getTarget().getClass();
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        if (args == null || args.length == 0) {
            executionMethod = executionCalss.getMethod(methodName);//获取无参的方法
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            executionMethod = executionCalss.getMethod(methodName, classArgs);
        }

    }

    @After("execution(* com.practice.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {

        if (executionCalss != SysLogController.class) {
            RequestMapping classAnnotation = (RequestMapping) executionCalss.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                RequestMapping methodAnnotation = executionMethod.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String url = "";
                    url = classAnnotation.value()[0] + methodAnnotation.value()[0];

                    SysLog sysLog = new SysLog();
                    long executionTime = new Date().getTime() - startTime.getTime();
                    sysLog.setExecutionTime(executionTime);
                    sysLog.setUrl(url);

                    String ip = httpServletRequest.getRemoteAddr();
                    sysLog.setIp(ip);

                    SecurityContext context = SecurityContextHolder.getContext();
                    String username = ((User) (context.getAuthentication().getPrincipal())).getUsername();
                    sysLog.setUsername(username);

                    sysLog.setMethod("[类名]" + executionCalss.getName() + "[方法名]" + executionMethod.getName());
                    sysLog.setVisitTime(startTime);
                    sysLogService.save(sysLog);
                }
            }
        }

    }

}
