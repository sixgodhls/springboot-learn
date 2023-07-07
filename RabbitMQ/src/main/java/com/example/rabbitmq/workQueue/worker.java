package com.example.rabbitmq.workQueue;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class worker {
    @RabbitListener(queues = "task_queue",concurrency = "3", ackMode = "MANUAL")
    public void process(String message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel){
        String s = new String(message.getBytes());
        System.out.println(message);
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.println("done");
            try {
                channel.basicAck(deliveryTag,false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
