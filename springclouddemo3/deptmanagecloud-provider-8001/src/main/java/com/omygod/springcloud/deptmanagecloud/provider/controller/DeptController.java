package com.omygod.springcloud.deptmanagecloud.provider.controller;

import com.omygod.springcloud.deptmanagecloud.provider.entity.Dept;
import com.omygod.springcloud.deptmanagecloud.provider.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provider/dept")
public class DeptController {

    @Autowired
    IDeptService deptService;

    @GetMapping("/get/{id}")
    public Dept getDept(@PathVariable(value = "id") Integer id){
        return deptService.getById(id);
    }

    @GetMapping("/list")
    public List<Dept> getDeptList(){
        return deptService.list();
    }
}