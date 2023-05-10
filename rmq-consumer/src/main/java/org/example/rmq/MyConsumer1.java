package org.example.rmq;

import cn.hutool.core.lang.Dict;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RocketMQMessageListener(topic = "audience_package_list", consumerGroup = "audience_local")
public class MyConsumer1 implements RocketMQListener<String> {

    public void onMessage(String s) {
        JSONArray array = JSONUtil.parseArray(s);
        List<Dict> list = JSONUtil.toList(array, Dict.class);
        for(Dict dict:list) {
            System.out.println(dict);
            System.out.println("----------------------------\r\n");
        }
    }
}
