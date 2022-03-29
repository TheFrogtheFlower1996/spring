package com.zh.statics;

/**
 * @author zh
 * @date 2022/3/29 15:59
 * @description:说明 目标对象
 */
public class You implements RentHouse{
    @Override
    public void toRentHouse() {
        System.out.println("目标对象，租到房子");
    }
}
