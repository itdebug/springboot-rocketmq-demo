package org.example.rmq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.example.RmqConsumerApp;
import org.example.model.OrderPaidEvent;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(topic = "test-topic-2", consumerGroup = "my-consumer_test-topic-2")
public class MyConsumer2 implements RocketMQListener<String> {
    public void onMessage(String o) {
        System.out.println("[test-topic-2]received orderPaidEvent: " + o);
    }
}
