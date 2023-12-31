package com.example.rabbitmq.simple;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String message){
        rabbitTemplate.convertAndSend("hello",message);
        System.out.println(message);
    }
}
