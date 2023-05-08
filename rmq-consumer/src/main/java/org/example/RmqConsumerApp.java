package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;

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
    @RocketMQMessageListener(topic = "elc-crm", consumerGroup = "my-consumer_test-topic-1")
    public class MyConsumer1 implements RocketMQListener<String> {
        public void onMessage(String message) {
            System.out.println("received message: " + message);
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
