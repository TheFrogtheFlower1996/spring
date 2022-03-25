package com.zh.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zh
 * @date 2022/3/25 11:34
 * @description: Bean属性对象，用来存放配置文件中的bean标签和class属性值
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyBean {

    private String id;
    private String clazz;

}
