package com.springcloud.study.servicerabbitmq.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * @author wufeng@chetong.net
 * @date 2017/12/1 15:56
 */
@Component
public class Sender implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init(){
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if (b) {
            System.out.println("消息发送成功:" + correlationData);
        } else {
            System.out.println("消息发送失败:" + s);
        }
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println(message.getMessageProperties().getCorrelationIdString() + " 发送失败");
    }

    //发送消息，不需要实现任何接口，供外部调用。
    public void send(String msg){

        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        System.out.println("开始发送消息 : " + msg.toLowerCase());
        String response = rabbitTemplate.convertSendAndReceive("topicExchange", "key.1", msg, correlationId).toString();
        System.out.println("结束发送消息 : " + msg.toLowerCase());
        System.out.println("消费者响应 : " + response + " 消息处理完成");
        System.out.println("-----------------------------------------------------------");
    }

}
