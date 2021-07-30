package com.self.rabbitmq.one;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.self.rabbitmq.utils.RabbitMqUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName:Worker01
 * @Description:
 * @Date:2021/7/29 10:36
 * @Author:wdb
 **/
@Slf4j
public class Worker03 {
    private final static String ACK_QUEUE_NAME = "ack_que";


    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        System.out.println("C2 等待接收消息处理时间较长");

        DeliverCallback deliverCallback=(var1, var2)->{
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("获取的消息{}",new String(var2.getBody()));
            /**
             * 1.消息标记 tag
             * 2.是否批量应答未应答消息
             */
            channel.basicAck(var2.getEnvelope().getDeliveryTag(),false);
        };

        CancelCallback cancelCallback=(var1)->{
            log.info(var1+"消费者取消消费接口回调逻辑");
        };
        boolean ack=false;
        channel.basicConsume(ACK_QUEUE_NAME,ack,deliverCallback,cancelCallback);
    }
}
