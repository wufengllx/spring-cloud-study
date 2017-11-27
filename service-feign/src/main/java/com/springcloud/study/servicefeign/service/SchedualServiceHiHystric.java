package com.springcloud.study.servicefeign.service;

import org.springframework.stereotype.Component;

/**
 * @author wufeng@chetong.net
 * @date 2017-11-27 11:00
 *
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}