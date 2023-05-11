package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class RmqProducerApp implements CommandLineRunner
{
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public static void main(String[] args){
        SpringApplication.run(RmqProducerApp.class, args);
    }

    public void run(String... args) throws Exception {
        while (true) {
            rocketMQTemplate.convertAndSend("elc-crm1", "Hello, World!");
            rocketMQTemplate.send("test-topic-2", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
            rocketMQTemplate.convertAndSend("test-order-topic-2", new OrderPaidEvent("T_001", new BigDecimal("88.00")));
        }


//        rocketMQTemplate.destroy(); // notes:  once rocketMQTemplate be destroyed, you can not send any message again with this rocketMQTemplate
    }

    @Data
    @AllArgsConstructor
    public class OrderPaidEvent implements Serializable {
        private String orderId;

        private BigDecimal paidMoney;
    }
}
