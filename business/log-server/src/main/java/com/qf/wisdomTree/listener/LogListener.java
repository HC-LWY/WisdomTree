package com.qf.wisdomTree.listener;

import com.alibaba.fastjson2.JSON;
import com.qf.wisdomTree.service.LogService;
import com.qf.wisdomTree.vo.Log;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LogListener {

    @Autowired
    private LogService logService;


    @RabbitListener(queues = {"logQueue"})
    public void putPostAdmin(Log log){
        System.out.println("[[[[["+log);

        logService.save(log);
    }







}
