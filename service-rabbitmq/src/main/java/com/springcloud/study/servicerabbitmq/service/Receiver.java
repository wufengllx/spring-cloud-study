package com.springcloud.study.servicerabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wufeng@chetong.net
 * @date 2017/12/1 16:07
 */
@Component
public class Receiver {

    @RabbitListener(queues = "user.queue")
    public String processMessage1(String msg) {
        System.out.println(Thread.currentThread().getName() + " 接收到来自user.queue队列的消息：" + msg);
        return msg.toUpperCase();
    }

    @RabbitListener(queues = "hello.queue")
    public void processMessage2(String msg) {
        System.out.println(Thread.currentThread().getName() + " 接收到来自hello.queue队列的消息：" + msg);
    }

}
