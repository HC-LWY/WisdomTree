package com.qf.wisdomTree.queue;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class THTBQueue {



    @Bean
    public Queue thtbQueue(){

        return new Queue("THTBQueue");
    }

}
