package com.example.eurakeproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient   // 表明自己属于一个生产者
@RestController
public class EurakeProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurakeProducerApplication.class, args);
    }


    @RequestMapping("sayHello")
    public String sayHello(String param) {
        return "Hello " + param;
    }
}
