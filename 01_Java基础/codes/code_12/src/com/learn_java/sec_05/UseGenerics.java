package com.learn_java.sec_05;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;

public class UseGenerics {
    @Test
    public void test1() {
        Object obj = null;
        String str = "hello";

        obj = str; //基于继承性的多态的使用

        Object[] o_arr = null;
        String[] s_arr = new String[]{"Tom", "Jerry", "Jack"};

        o_arr = s_arr; //基于继承性的多态的使用

        ArrayList<Object> list1 = null;
        ArrayList<String> list2 = null;

//        list1 = list2; //编译不通过
    }

    @Test
    public void test2() {
        List<String> list1 = null;
        ArrayList<String> list2 = null;

        list1 = list2; //编译通过
        list1.add("hello");
    }
}
