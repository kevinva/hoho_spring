package com.example.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.consumer.service.impl.ComsumerServiceImpl;  // hoho_todo: 竟然可以与ConsumerServiceImpl互相import?!

@FeignClient(name = "provider", fallback = ComsumerServiceImpl.class)
@Service
public interface ConsumerService {

    @GetMapping("/helloProvider")   // hoho_todo1: 是否要与provider的url对应上？ | 必须对上！
    String getHello();

}
