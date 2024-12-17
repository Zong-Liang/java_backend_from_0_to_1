package com.learn_java.sec_02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class UseIterator {
    @Test
    public void test1() {
        Collection coll1 = new ArrayList();

        coll1.add("abc");
        coll1.add(128);
        coll1.add(new Object());
        coll1.add(new Person("Tom", 12));

        //获取迭代器对象
        Iterator iter = coll1.iterator();
//        System.out.println(iter.next());
//        System.out.println(iter.next());
//        System.out.println(iter.next());
//        System.out.println(iter.next());
//
//        System.out.println(iter.next()); //超出实际个数报异常NoSuchElementException

//        for (Object obj : coll1) {
//            System.out.println(obj);
//        }

        //推荐
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }

    @Test
    public void test2() {
        int[] i_arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        //增强for循环
        for (int i : i_arr) {
            System.out.println(i);
        }
    }
}
