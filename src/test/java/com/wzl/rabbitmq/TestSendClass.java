package com.wzl.rabbitmq;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wzl.rabbitmq.producer.MessageProducer;

public class TestSendClass {

	private ApplicationContext context = null;
	
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring.xml");
    }
    
    @Test  
    public void sendMessage2Queue() throws Exception {
        MessageProducer messageProducer = (MessageProducer) context.getBean("messageProducer");
        for(int i=0;i<5;i++) {
        	String str = "Hello, message by queue num :" + i;
            messageProducer.sendMessage2Queue(str);
            try {  
                //暂停一下，好让消息消费者去取消息打印出来  
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();  
            }  
            System.out.println("发送成功"+str);
        }  
    }
    
    @Test
    public void sendMessage2Exchange() throws Exception {
        MessageProducer messageProducer = (MessageProducer) context.getBean("messageProducer");
        for(int i=0;i<5;i++) {
        	String str = "Hello, message by exchange num :" + i;
            messageProducer.sendMessage2Exchange(str);
            try {  
                //暂停一下，好让消息消费者去取消息打印出来  
                Thread.sleep(500);  
            } catch (InterruptedException e) {
                e.printStackTrace();  
            }  
            System.out.println("发送成功"+str);
        }  
    } 

}
