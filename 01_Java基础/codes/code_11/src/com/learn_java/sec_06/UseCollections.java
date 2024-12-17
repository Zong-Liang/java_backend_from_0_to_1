package com.learn_java.sec_06;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class UseCollections {
    @Test
    public void test1() {
        var list1 = Arrays.asList(12, 54, 67, 88, 3, 6, 75, 24, 6, 79, 46, 8, 74, 7);
        System.out.println(list1);

        //reverse()反转List中元素的顺序
        Collections.reverse(list1);
        System.out.println(list1);

        //对List进行随机排序
        Collections.shuffle(list1);
        System.out.println(list1);

        //进行自然排序
        Collections.sort(list1);
        System.out.println(list1);

        //定制排序
        Collections.sort(list1, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer) {
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;

                    //降序
//                    return -(i1 - i2);
                    return -(i1.intValue() - i2.intValue());
                } else {
                    throw new RuntimeException();
                }
            }
        });
        System.out.println(list1);

        System.out.println(Collections.max(list1)); //自然排序里的最大值
        System.out.println(Collections.min(list1)); //自然排序里的最小值

        //判断某个元素在当前集合中出现了几次
        System.out.println(Collections.frequency(list1, 6));

        //复制list1内容到list2中
        //错误写法
//        var list2 = new ArrayList();
//        Collections.copy(list2, list1); //IndexOutOfBoundsException
        var list2 = Arrays.asList(new Object[list1.size()]);
        Collections.copy(list2, list1);
        System.out.println(list2);

        //多个unmodifiableList()方法返回一个不可变的集合
        var list3 = new ArrayList();
        list3.add(12);
        list3.add(34);
        list3.add(56);

        var list4 = Collections.unmodifiableList(list3); //此时list4只能读不能写
//        list4.add(78); //UnsupportedOperationException
        System.out.println(list4.get(0));

        Collections.addAll(list3, 78, 90);
        System.out.println(list3);

        //synchronizedList()返回一个线程安全的集合
        var list5 = Collections.synchronizedList(list3);
        System.out.println(list5);

        //emptyList()返回一个空的集合
        var list6 = Collections.emptyList();
        System.out.println(list6);
    }
}
