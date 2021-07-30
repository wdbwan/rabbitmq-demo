package com.self.rabbitmq.one;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName:Producer
 * @Description:
 * @Date:2021/7/29 9:16
 * @Author:wdb
 **/
@Slf4j
public class Producer {
//    private final static String QUEUE_NAME = "hello";
    private final static String QUEUE_NAME = "hello_cluster";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建一个rabbitmq连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setHost("192.168.238.166");

        //新建信道
        Connection connection = factory.newConnection();
        //channel实现了Closeable接口，不需要手动关闭
        Channel channel = connection.createChannel();


        /*
         * queue：队列名字
         * durable:是否队列持久化
         * exclusive:是否允许多个消费者共享
         * autoDelete：是否自动删除，最后一个消费者端开连接以后 该队列是否自动删除 true 自动删除
         * arguments：其它参数
         * */
        boolean durable=true;//开启队列持久化
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
        String message="hello rabbitmq";

        //发送消息
        log.info("开始发送消息");
        //仍不能保证消息持久化
        AMQP.BasicProperties persistentTextPlain = MessageProperties.PERSISTENT_TEXT_PLAIN;
        channel.basicPublish("",QUEUE_NAME,persistentTextPlain,message.getBytes());
    }

}
