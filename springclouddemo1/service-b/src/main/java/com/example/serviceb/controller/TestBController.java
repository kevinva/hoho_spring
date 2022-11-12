package com.example.serviceb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@EnableFeignClients
public class TestBController {

    @Autowired
    private ServiceAFeignClient serviceAFeignClient;

    @RequestMapping("call")
    public String call() {
        String result = serviceAFeignClient.TestAController();
        return "b to a 访问结果 ---" + result;
    }

}
