package com.example.springboot.common;

import com.example.springboot.entity.DormRoom;
/**
 * @Description: 记录入住人数
 * @Param:
 * @return:
 * @Author: 鸣翊seki
 * @Date:
 */
public class CalPeopleNum {

    public static int calNum(DormRoom dormRoom) {
        int count = 0;

        if (dormRoom.getFirstBed() != null) {
            count++;
        }
        if (dormRoom.getSecondBed() != null) {
            count++;
        }
        if (dormRoom.getThirdBed() != null) {
            count++;
        }
        if (dormRoom.getFourthBed() != null) {
            count++;
        }
        return count;
    }
}
