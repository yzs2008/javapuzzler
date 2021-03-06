package com.zzu.kaidi.java.puzzles.rocketmq;


import java.util.List;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * Created by IntelliJ IDEA.
 * User: kaidi
 * Date: 2016/5/8
 * Time: 17:57
 * Write the code, Change the world.
 */
public class ConsumerTest {
  public static void main(String[] args) {
    DefaultMQPushConsumer consumer =
            new DefaultMQPushConsumer("PushConsumer");
    consumer.setNamesrvAddr("115.29.99.89:9876");
    try {
      //订阅PushTopic下Tag为push的消息
      consumer.subscribe("PushTopic", "push");
      //程序第一次启动从消息队列头取数据
      consumer.setConsumeFromWhere(
              ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
      consumer.registerMessageListener(
              new MessageListenerConcurrently() {
                public ConsumeConcurrentlyStatus consumeMessage(
                                                                       List<MessageExt> list,
                                                                       ConsumeConcurrentlyContext Context) {
                  Message msg = list.get(0);
                  System.out.println(msg.toString());
                  return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
              }
      );
      consumer.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
