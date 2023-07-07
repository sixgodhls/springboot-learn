package com.example.rabbitmq;

import com.example.rabbitmq.simple.Sender;
import com.example.rabbitmq.workQueue.NewTask;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitMqApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private Sender sender;
    @Test
    public void test(){
        sender.send("111");
    }
    @Autowired
    private NewTask newTask;
    @Test
    public void test1(){
        for (int i = 0; i < 10; i++) {
            newTask.send(i+"");
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
