package com.wzl.rabbitmq.producer;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
	
    @Resource(name="amqpTemplate")  
    private AmqpTemplate amqpTemplate;
    
    public void sendMessage2Queue(Object message) throws IOException {
    	amqpTemplate.convertAndSend("spring.queue1", message);
    }
    
    public void sendMessage2Exchange(Object message) throws IOException {
    	amqpTemplate.convertAndSend("spring.queue.exchange","spring.queue.key2", message);
    }
    
}
