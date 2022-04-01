package com.zh.statics;

import javax.print.DocFlavor;

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

    @Override
    public String toRentHouse2(String name) {
        System.out.println(name+"（目标对象）租到房子啦");

        return "result01";
    }
}
