package org.example.rmq.sub;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(topic = "TopicTest", consumerGroup = "TopicTest_G2", consumeMode = ConsumeMode.ORDERLY)
public class TopicTestConsumer2 implements RocketMQListener<String> {

    public void onMessage(String s) {
        System.out.println("TopicTest_G2:" + s);
    }
}
