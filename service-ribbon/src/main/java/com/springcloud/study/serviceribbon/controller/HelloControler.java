package com.springcloud.study.serviceribbon.controller;

import com.springcloud.study.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wufeng@chetong.net
 * @date 2017-11-27 11:00
 *
 */
@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        System.out.println("============================"+name);
        return helloService.hiService(name);
    }

}
