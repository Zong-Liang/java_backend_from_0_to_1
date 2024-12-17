package com.learn_java.sec_06;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;

public class UseGenerics {
    //通配符的使用
    @Test
    public void test1() {
        List<?> list = null;

        List<Object> list1 = null;
        List<String> list2 = null;

        list = list1;
        list = list2;

        method(list1);
        method(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");

        list = list3;

        //添加(写入)：对于List<?>就不能向其内部添加数据
//        list.add("CC");
//        list.add(123);
        list.add(null); //只能添加null

        //获取(读取)：允许读取数据，读取的数据类型为Object
        Object o = list.get(0);
        System.out.println(o);
    }

    public void method(List<?> list) {
    }

    @Test
    public void test2() {
        List<? extends Father> list1 = null;

        List<Object> list2 = null;
        List<Father> list3 = null;
        List<Son> list4 = null;

//        list1 = list2; //编译不通过
        list1 = list3;
        list1 = list4;

        //读取数据：
        list1 = list3;
        Father father = list1.get(0);
        //编译不通过
//        Son son = list1.get(0);

        //编译不通过
//        list1.add(new Father());

        //编译不通过
//        list1.add(new Son());

        //编译不通过
//        list1.add(new Object());

        list1.add(null);
    }

    @Test
    public void test3() {
        List<? super Father> list1 = null;


        List<Object> list2 = null;
        List<Father> list3 = null;
        List<Son> list4 = null;

        list1 = list2;
        list1 = list3;
//        list1 = list4; //编译不通过

        //添加
        list1.add(new Father());
        list1.add(new Son());

        //获取
        Object object = list1.get(0);
    }
}
