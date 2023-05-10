package org.example.rmq;

import cn.hutool.core.lang.Dict;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RocketMQMessageListener(topic = "TopicTest", consumerGroup = "local", consumeMode = ConsumeMode.ORDERLY)
public class TopicTestConsumer1 implements RocketMQListener<String> {

    public void onMessage(String s) {
        System.out.println("TopicTest:" + s);
    }
}
