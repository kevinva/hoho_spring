package com.omygod.springcloud.deptmanagecloud.provider.service;

import com.omygod.springcloud.deptmanagecloud.provider.entity.Dept;

import java.util.List;

public interface IDeptService {

    public Dept getById(Integer id);

    public List<Dept> list();

}
