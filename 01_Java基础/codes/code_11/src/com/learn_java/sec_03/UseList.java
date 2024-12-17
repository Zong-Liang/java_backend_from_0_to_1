package com.learn_java.sec_03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class UseList {
    @Test
    public void test1() {
        List list1 = new ArrayList();

        //add(Object obj)添加元素到当前集合中
        list1.add(0, "abc");
        list1.add(1, 128);

        System.out.println(list1.toString());

        List list2 = Arrays.asList(1, 2, 3);
//        list1.add(1, list2);
        list1.addAll(1, list2);
        System.out.println(list1);

        //删除索引2位置的元素
        list1.remove(2);
        System.out.println(list1);
        System.out.println(list1.get(2));

        //删除值为1的元素
        list1.remove(Integer.valueOf(1));
        System.out.println(list1);

        for (Object obj : list1) {
            System.out.println(obj);
        }

        Iterator iter = list1.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

    }
}
