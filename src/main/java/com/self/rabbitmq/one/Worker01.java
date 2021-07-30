package com.self.rabbitmq.one;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.self.rabbitmq.utils.RabbitMqUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName:Worker01
 * @Description:
 * @Date:2021/7/29 10:36
 * @Author:wdb
 **/
@Slf4j
public class Worker01 {
    private final static String QUEUE_NAME = "hello";



    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        DeliverCallback deliverCallback=(var1, var2)->{
            log.info("获取的消息{}",new String(var2.getBody()));
        };

        CancelCallback cancelCallback=(var1)->{
            log.info("cancelCallback -> var1");
        };
        channel.basicConsume(QUEUE_NAME,false,deliverCallback,cancelCallback);
    }
}
