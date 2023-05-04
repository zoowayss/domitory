package com.example.springboot.common;

import java.util.UUID;
    /**
     * @Description: 表示通用唯一标识符 (UUID) 的类。 UUID 表示一个 128 位的值。
     * 随机生成36位的随机字符串   例如：07968384-85df-4a6b-bff9-22678ebb21c2
     * @Param:
     * @return:
     * @Author: 鸣翊seki
     * @Date:
     */
public class UID {
    public String produceUID() {
        //可对生成的字符串进行处理例如去掉字符串中的“-“此时长度为32位，可以用作表的主键等
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
