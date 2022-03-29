package com.zh.service;

import com.zh.dao.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * @author zh
 * @date 2022/3/28 9:34
 * @description:说明 service 调用 dao 手动
 */
public class TypeService {

    //bean对象
    @Autowired
    @Qualifier("td")
    private TypeDao typeDao;

    public void test() {
        System.out.println("TypeService....业务类");
//        typeDao.test1();
    }

}
