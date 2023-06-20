package com.qf.wisdomTree.queue;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminQueueConfig {

    @Bean
    public Exchange logExchange(){
        return ExchangeBuilder.topicExchange("logExchange").durable(true).build();
    }

    @Bean
    public Queue logQueue(){
        return new Queue("logQueue",true,false,false,null);
    }

    @Bean
    public Binding BINDING_QUEUE_PUT(@Qualifier("logQueue") Queue queue,
                                     @Qualifier("logExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("/*").noargs();
    }


}
