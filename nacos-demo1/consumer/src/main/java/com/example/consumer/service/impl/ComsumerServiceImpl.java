package com.example.consumer.service.impl;

import com.example.consumer.service.ConsumerService;
import org.springframework.stereotype.Component;

@Component
public class ComsumerServiceImpl implements ConsumerService {


    @Override
    public String getHello() {
        return "服务出错";
    }
}
