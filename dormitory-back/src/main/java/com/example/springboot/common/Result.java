package com.example.springboot.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
    /**
     * @Description: 返回前台数据的包装类
     * controller层用它封装数据，返回前端
     * 前后端分离中，便于统一返回给前端的格式 ，用于开发返回数据封装结果集Result工具类
     * @Author: 鸣翊seki
     * @Date: 
     */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
        /**
         * 状态码
         */
    private String code;
        /**
         * 状态信息
         */
    private String msg;
        /**
         * 泛类存储数据返回
         */
    private T data;

    public Result(T data) {
        this.data = data;
    }

    public static Result success() {
        Result result = new Result<>();
        result.setCode("0");
        result.setMsg("成功");
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(data);
        result.setCode("0");
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    public static Result error(String code, String msg) {
        Result result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
