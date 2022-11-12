package com.example.eurakeconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient   // 表明标注类是消费者
public class EurakeConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurakeConsumerApplication.class, args);
    }

    @Bean  // hoho_todo
    @LoadBalanced  // hoho_todo
    // 加入restTemplate来消费相关服务
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
