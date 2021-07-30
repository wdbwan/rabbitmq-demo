package com.self.rabbitmq.two;

import com.rabbitmq.client.Channel;
import com.self.rabbitmq.utils.RabbitMqUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName:PublishConfirm
 * @Description:
 * @Date:2021/7/29 15:06
 * @Author:wdb
 **/
@Slf4j
public class PublishConfirm {


    public static void main(String[] args) {

    }

    public static void publishMessageIndividually() throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();

    }
}
