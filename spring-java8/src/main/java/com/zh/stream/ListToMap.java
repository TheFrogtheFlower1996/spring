package com.zh.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author zh
 * @date 2022/6/17 10:14
 * @description:说明
 */
public class ListToMap {

    public static void main(String[] args) {

        Person person = new Person("张三","北京");
        Person person1 = new Person("李四","上海");
        Person person2 = new Person("李四","上海2");

        List<Person> list = new ArrayList<>();
        Collections.addAll(list,person,person1,person2);

//        System.out.println(list);
        Stream<Person> stream = list.stream();
        Map<String,Person> map = new HashMap<>();

        stream.forEach(x-> map.put(x.getId(),x));
        System.out.println(map);


    }


}


