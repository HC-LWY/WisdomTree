package com.qf.wisdomTree;

import com.qf.wisdomTree.vo.Log;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


//@SpringBootTest
class LogApplicationTest {

//    @Autowired
    RabbitTemplate rabbitTemplate;

//    @Autowired
    AmqpTemplate amqpTemplate;
//    @Test
    void test(){
        Log log=new Log();
        log.setOperation("添加");
        amqpTemplate.convertAndSend("logQueue",log);
    }

}