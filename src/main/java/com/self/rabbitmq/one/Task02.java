package com.self.rabbitmq.one;

import com.rabbitmq.client.Channel;
import com.self.rabbitmq.utils.RabbitMqUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName:Task01
 * @Description:
 * @Date:2021/7/29 10:31
 * @Author:wdb
 **/
@Slf4j
public class Task02 {
    private final static String ACK_QUEUE_NAME = "ack_que";

    public static void main(String[] args) throws IOException, TimeoutException {

        Channel channel = RabbitMqUtils.getChannel();

        channel.queueDeclare(ACK_QUEUE_NAME,false,false,false,null);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        while (scanner.hasNext()){
            String message = scanner.next();
            channel.basicPublish("",ACK_QUEUE_NAME,null,message.getBytes());

        }


    }
}
