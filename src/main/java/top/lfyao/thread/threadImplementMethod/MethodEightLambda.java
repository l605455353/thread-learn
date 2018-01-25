package top.lfyao.thread.threadImplementMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Lambda方式实现
 */
public class MethodEightLambda {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(5, 30, 90, 100, 110);
        int i = new MethodEightLambda().addList(list);
        System.out.println("计算的结果为："+i);
    }

    public int addList(List<Integer> list) {
        // 串行
        list.stream().forEach(System.out::println);


        /*// 并行 遍历 有序
        list.parallelStream().forEachOrdered(System.out::println);*/

      /*  // 并行 遍历
        list.parallelStream().forEach(System.out::println);*/
        return 1;
        // parallelStream并行流
//        return list.parallelStream().mapToInt(i -> i * 2).sum();
    }
}
