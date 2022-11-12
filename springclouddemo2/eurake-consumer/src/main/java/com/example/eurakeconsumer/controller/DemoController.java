package com.example.eurakeconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("greet")
    public String greet(@RequestParam String name) {
        return restTemplate.getForObject("http://eureka-producer/sayHello?param=" + name, String.class);
    }

}
