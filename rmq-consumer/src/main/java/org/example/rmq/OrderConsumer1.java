package org.example.rmq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.example.model.OrderPaidEvent;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(topic = "test-order-topic-2", consumerGroup = "test-order-topic-2")
public class OrderConsumer1 implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        System.out.println("OrderConsumer1: " + s);
    }
}
