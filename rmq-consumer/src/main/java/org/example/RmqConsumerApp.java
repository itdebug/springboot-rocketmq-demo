package org.example;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class RmqConsumerApp
{
    public static void main(String[] args){
        SpringApplication.run(RmqConsumerApp.class, args);
    }

    @Service
    @RocketMQMessageListener(topic = "audience_package_list", consumerGroup = "topic-1")
    public class MyConsumer1 implements RocketMQListener<String> {

        public void onMessage(String s) {
            System.out.println("received audience_package_list: " + s);
        }
    }

    @Service
    @RocketMQMessageListener(topic = "test-topic-2", consumerGroup = "my-consumer_test-topic-2")
    public class MyConsumer2 implements RocketMQListener<OrderPaidEvent>{
        public void onMessage(OrderPaidEvent orderPaidEvent) {
            System.out.println("received orderPaidEvent: " + orderPaidEvent);
        }
    }

    @Data
    @AllArgsConstructor
    public class OrderPaidEvent implements Serializable {
        private String orderId;

        private BigDecimal paidMoney;
    }
}
