package com.example.serviceb.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service-objcat-a")
public interface ServiceAFeignClient {

    @RequestMapping("testA")  // hoho_test
    public String TestAController();

}
