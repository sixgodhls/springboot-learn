package com.example.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SimpleRabbitConfig {
    private final static String QUEUE_NAME="hello";

    @Bean
    public Queue helloQueue(){
        return new Queue(QUEUE_NAME,false);
    }
}
