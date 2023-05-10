package org.example.controller.delay.imp;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.example.controller.delay.ScheduleMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScheduleMessageServiceImpl implements ScheduleMessageService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    private static final Logger logger = LoggerFactory.getLogger(ScheduleMessageServiceImpl.class);

    @Override
    public void sendSyncScheduleMessage(String topic, String id, String message, long timeout, int delayLevel) {
        Message<String> strMessage = MessageBuilder.withPayload(message).setHeader(RocketMQHeaders.KEYS, id).build();
        SendResult result = rocketMQTemplate.syncSend(topic + ":sync-tags", strMessage, timeout, delayLevel);
        if (result.getSendStatus() == SendStatus.SEND_OK) {
            logger.info("发送同步定时消息成功!消息ID为:{},当前时间为:{}", result.getMsgId(), LocalDateTime.now());
        } else {
            logger.info("发送同步定时消息失败!消息ID为:{}", result.getMsgId());
        }
    }
}
