package com.example.consumer.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.example.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RefreshScope
@Validated
public class ConsumerController {

    @NacosValue(value = "${datasource.url:123}", autoRefreshed = true)   // 后面的123为默认值
    private String url;

    @NacosValue(value = "${datasource.username:123}", autoRefreshed = true) // 后面的123为默认值
    private String username;

    @NacosValue(value = "${datasource.password:123}", autoRefreshed = true) // 后面的123为默认值
    private String password;

    @NacosValue(value = "${hoho.name:123}", autoRefreshed = true)
    private String hoho_name;

    @Autowired
    private RestTemplate restTemplate;

    @Resource  // 这里用@Autowired标注也可以
    private ConsumerService consumerService;

    @GetMapping("/getHello")
    public String getHello() {
        System.out.println("url: " + url);
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("hoho_name: " + hoho_name);

        return consumerService.getHello();
    }

}
