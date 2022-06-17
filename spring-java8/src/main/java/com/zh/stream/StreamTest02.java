package com.zh.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author zh
 * @date 2022/6/16 22:53
 * @description:说明 stream 串行流 和 并行流
 */
public class StreamTest02 {
    public static void main(String[] args) {

        // 创建Stream方式1 list、set 直接调用stream()方法
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,3);
        Stream<Integer> stream1 = list.stream();

        //创建Stream方式2 基本数据类型数组 调用Arrays.stream()
        int[] arr = {1,2,3,4,5,6,7,};
        IntStream stream = Arrays.stream(arr);

        //获取并行流,调用 parallelStream() 方法，底层采用 ForkJoin 框架，结果并按照集合原有顺序输出
        Stream<Integer> integerStream = list.parallelStream();


    }
}
