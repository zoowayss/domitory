package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统管理员
 */
/**
 * @NoArgsConstructor 生成无参的构造方法。
 * @AllArgsConstructor 生成该类下全部属性的构造方法。
 * @Data 注解的主要作用是提高代码的简洁，使用这个注解可以省去代码中大量的get()、 set()、 toString()等方法；
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@TableName(value = "admin")
public class Admin {

    @TableId(value = "username")
    private String username;
    @TableField(value = "password")
    private String password;
    @TableField(value = "name")
    private String name;
    @TableField(value = "gender")
    private String gender;
    @TableField(value = "age")
    private int age;
    @TableField(value = "phone_num")
    private String phoneNum;
    @TableField(value = "email")
    private String email;
    @TableField("avatar")
    private String avatar;
}
