package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.entity.Admin;

//service层需要继承IService，当然实现层也要继承对应的实现类。
public interface AdminService extends IService<Admin> {


    //管理员登陆
    Admin adminLogin(String username, String password);

    //更新管理员信息
    int updateAdmin(Admin admin);

}
