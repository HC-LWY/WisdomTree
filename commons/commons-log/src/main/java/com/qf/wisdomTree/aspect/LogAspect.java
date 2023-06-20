package com.qf.wisdomTree.aspect;

import com.alibaba.fastjson.JSON;
import com.qf.wisdomTree.annotation.OutLog;
import com.qf.wisdomTree.vo.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;


@Aspect
@Component
public class LogAspect {


    @Autowired
    private AmqpTemplate amqpTemplate;


    @Pointcut("@annotation(com.qf.wisdomTree.annotation.OutLog)")
    private void annotationPointcut(){}

    @Around("annotationPointcut()")
    public Object annotationAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Log log=new Log();

        //获取注解中的参数
        Method method=((MethodSignature)joinPoint.getSignature()).getMethod();
        OutLog outLog=method.getAnnotation(OutLog.class);
        String operation = outLog.operation();
        String resources = outLog.resources();
        String user = outLog.user()==null||outLog.user().equals("")?"某某":outLog.user();

        String remarks = outLog.remarks();
        StringBuffer stringBuffer=new StringBuffer();
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = simpleDateFormat.format(date);

        //获取方法中的参数
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
            log.setObject(arg.toString());
        }

        stringBuffer.append(user).append("在").append(createTime).append(operation).append(resources).append("一条数据,数据信息为").append(log.getObject());




        //封装好日志对象
        log.setOperation(operation);
        log.setCreateTime(date);
        log.setUsername(user);
        log.setRemarks(remarks);
        log.setResources(resources);
        log.setLogContent(stringBuffer.toString());




        //利用消息中间件将日志对象发送给日志服务
        System.out.println(log);
        String s = JSON.toJSONString(log);

        amqpTemplate.convertAndSend("logQueue",log);

        //放行
        return joinPoint.proceed();
    }

}
