package com.zh.springmvc.controller;

import com.zh.springmvc.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zh
 * @date 2022/4/8 14:39
 * @description:说明
 *
 * JSON
 *
 * @ResponseBody
 *      默认控制器中方法的返回值是会去找对应的视图页面，如果想要返回数据，需要将返回的结果转换成字符串响应（转换成JSON字符串）
 *      放在方法前
 * @RequestBody
 *      要求传递过来一个JSON格式的字符串
 *      放在参数前
 *
 */
@Controller
@RequestMapping("json")
public class JsonController {

    /**
     * 返回json数据
     * */
    @RequestMapping("index")
    @ResponseBody
    public /*@ResponseBody*/ User index(){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        return user;
    }

    @RequestMapping("index02")
    @ResponseBody
    public User index02(@RequestBody User user){
        return user;
    }
}