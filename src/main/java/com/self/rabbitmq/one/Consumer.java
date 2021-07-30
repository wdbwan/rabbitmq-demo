package com.self.rabbitmq.one;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName:Consumer
 * @Description:
 * @Date:2021/7/29 9:40
 * @Author:wdb
 **/
@Slf4j
public class Consumer {
//    private final static String QUEUE_NAME = "hello";
    private final static String QUEUE_NAME = "hello_cluster";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.238.166");
        factory.setUsername("admin");
        factory.setPassword("admin");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //推送的消息如何进行消费的接口回调
        DeliverCallback deliverCallback = (var1, var2) -> {
            String s = new String(var2.getBody());
            log.info(s);
        };
        //取消消费的一个回调接口 如在消费的时候队列被删除掉了
        CancelCallback cancelCallback = (consumerTag) ->{
            log.info("消息中断");
        };

        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);
    }
}
