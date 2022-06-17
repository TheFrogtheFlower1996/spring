package com.zh.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zh
 * @date 2022/6/16 20:35
 * @description:说明 Stream流式编程
 */
public class StreamTest {
    public static void main(String[] args) {

        //需求：排序 去重
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,5,2,78,64,24,1,56,2,5);

        //获取Stream对象
        Stream<Integer> stream = list.stream();

        //中间操作
        stream = stream.sorted()//排序 默认升序
                .sorted((x,y)->Integer.compare(y,x)) //排序降序
                .distinct()//去重
                .limit(4)//截取
                .skip(0)//跳过
                .map(x->x+2)//操作数组中每个值
                .filter(x->x>7)//过滤

                ;

        //终止操作
        stream.forEach(x-> System.out.println(x));//遍历输出
        stream.count();//统计元素个数
        stream.findFirst().get();//Optional[80] 返回被Optional封装的第一个元素，get()取到元素
        stream.max(Comparator.comparingInt(x->x)).get(); //返回最大值
        stream.min(Comparator.comparingInt(x->x)).get(); //返回最小值
        stream.collect(Collectors.toList()); //把流中的元素收集到List

//        System.out.println(stream.min(Comparator.comparingInt(x->x)).get());



    }
}
