package com.example.rabbitmq.workQueue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewTask {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String message){
        rabbitTemplate.convertAndSend("task_queue",message,msg->{
            msg.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            return msg;
        });
        System.out.println(message);
    }
}
