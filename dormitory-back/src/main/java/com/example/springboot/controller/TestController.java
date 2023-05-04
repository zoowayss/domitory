package com.example.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Zoowayss Shi
 * @Date: 2023/5/3 11:26
 * @Version: 1.0
 */
@RequestMapping
@RestController
public class TestController {
    @RequestMapping("/test")
    public String test() {
        return "hello world";
    }
}
