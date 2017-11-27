package com.springcloud.study.cloudclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author wufeng@chetong.net
 * @date 2017-11-27 11:00
 *
 */
@RestController
public class TestController {
    private static final Logger log = Logger.getLogger(TestController.class.getName());
    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    String port;
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        log.log(Level.INFO,"hi is being called");
        return "hi "+name+",i am from port:" +port;
    }

    @RequestMapping("/info")
    public String info(){
        log.log(Level.INFO,"info is being called");
        return restTemplate.getForObject("http://localhost:8763/info",String.class);
    }

}
