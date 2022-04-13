package com.zh.springmvc.controller;

import com.zh.springmvc.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zh
 * @date 2022/4/7 15:30
 * @description:说明 参数控制器
 *
 * 1.基本数据类型
 *      @RequestParam(value = "a",defaultValue = "100") 设置别名和默认值
 *
 * 2.包装类型
 *      如果不传递参数，默认为null
 *
 * 3.字符串类型
 * 4.数组类型
 * 5.List数组
 * 6.Set数组
 * 7.Map
 *
 */
@Controller
public class ParamsController {

    /**
     * 基本数据类型
     * */
    @RequestMapping("params01")
    public void params01(int age,double money){
        System.out.println("数据："+age+" "+money);
    }

    @RequestMapping("params02")
    public void params02(@RequestParam(value = "a",defaultValue = "100") int age,@RequestParam(defaultValue = "100.0") double money){
        System.out.println("age："+age+"，money："+money);
    }

    /**
     * 包装类型
     * */
    @RequestMapping("params03")
    public void params03(Integer age,Double money){
        System.out.println("age："+age+"，money："+money);
    }

    /**
     * 字符串类型
     * */
    @RequestMapping("params04")
    public void params04(String age){
        System.out.println("age："+age);
    }

    /**
     * 数组类型
     * */
    @RequestMapping("params05")
    public void params05(Double[] age){
        System.out.println("age："+age);
        for (Double s : age) {
            System.out.println("age："+s);
        }
    }

    /**
     * JavaBean类型
     * */
    @RequestMapping("params06")
    public void params06(User user){
        System.out.println("user："+user);
    }


}
