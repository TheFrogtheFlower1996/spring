package com.zh.statics;

/**
 * @author zh
 * @date 2022/3/29 16:01
 * @description:说明 代理对象
 * 1. 实现行为
 * 2. 增强目标对象行为
 */
public class AgencyProxy implements RentHouse{

    //目标对象
    private RentHouse rentHouse;
    //有参构造函数，传入目标对象
    public AgencyProxy(RentHouse rentHouse) {
        this.rentHouse = rentHouse;
    }

    @Override
    public void toRentHouse() {
        System.out.println("中介找房");
        rentHouse.toRentHouse();
        System.out.println("中介收钱");
    }

    @Override
    public String toRentHouse2(String name) {
        return "as";
    }
}
