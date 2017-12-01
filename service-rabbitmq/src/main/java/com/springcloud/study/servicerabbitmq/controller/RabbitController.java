package com.springcloud.study.servicerabbitmq.controller;

import com.springcloud.study.servicerabbitmq.service.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wufeng@chetong.net
 * @date 2017/12/1 16:16
 */
@RestController
public class RabbitController {

    @Autowired
    private Sender sender;

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String testUserQueue(String msg){
        sender.send(msg);
        return "成功";
    }

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String testHelloQueue(String msg){
        sender.send(msg);
        return "成功";
    }
}
