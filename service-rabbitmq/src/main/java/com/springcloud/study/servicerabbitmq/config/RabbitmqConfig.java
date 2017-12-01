package com.springcloud.study.servicerabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author wufeng@chetong.net
 * @date 2017/12/1 15:41
 */
@Configuration
public class RabbitmqConfig {

    @Bean
    public Queue userQueue(){
        return new Queue("user.queue",true);
    }

    @Bean
    public Queue helloQueue(){
        return new Queue("hello.queue",true);
    }

    //声明交互器
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding bindingUserQueue(){
        return BindingBuilder.bind(userQueue()).to(topicExchange()).with("key.1");
    }

    @Bean
    public Binding bindingHelloQueue(){
        return BindingBuilder.bind(helloQueue()).to(topicExchange()).with("key.#");
    }

}
