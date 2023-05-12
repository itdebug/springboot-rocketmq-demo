package org.example.rmq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.example.model.OrderPaidEvent;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(topic = "elc-crm1", consumerGroup = "campaign")
public class CrmTest1Consumer2 implements RocketMQListener<String> {
    public void onMessage(String param) {
        System.out.println("received CrmTest1Consumer2: " + param);
    }
}
