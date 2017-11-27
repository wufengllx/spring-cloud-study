package com.springcloud.study.cloudclient2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author wufeng@chetong.net
 * @date 2017-11-27 11:00
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class CloudClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudClient2Application.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

}
