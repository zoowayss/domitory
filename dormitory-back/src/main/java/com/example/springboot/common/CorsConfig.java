package com.example.springboot.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
    /**
     * @Description: 配置跨域类，解决springboot跨域请求的问题
     * CORS是一个W3C标准，全称是"跨域资源共享"（Cross-origin resource sharing）。
     * 它允许浏览器向跨源服务器，发出XMLHttpRequest请求，从而克服了AJAX只能同源使用的限制。
     * @Param: 
     * @return: 
     * @Author: 鸣翊seki
     * @Date: 
     */
@Configuration
public class CorsConfig {


    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 1容许任何域名使用
        corsConfiguration.addAllowedHeader("*"); // 2容许任何头
        corsConfiguration.addAllowedMethod("*"); // 3容许任何方法（post、get等）
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4 对接口配置跨域设置
        return new CorsFilter(source);
    }
}