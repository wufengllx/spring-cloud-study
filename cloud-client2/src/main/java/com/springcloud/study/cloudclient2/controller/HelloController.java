package com.springcloud.study.cloudclient2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class HelloController {
    private static final Logger log = Logger.getLogger(HelloController.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String callHome(){
        log.log(Level.INFO,"hi is being called");
        return restTemplate.getForObject("http://localhost:8762/hi?name=client8632", String.class);
    }
    @RequestMapping("/info")
    public String info(){
        log.log(Level.INFO,"info is being called");
        return "i'm client-8763";
    }

}
