package com.learn_java.sec_04;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;

public class UseGenerics {
    @Test
    public void test1() {
        //未指定泛型参数类型按照Object类型处理
        Order order1 = new Order();
        System.out.println(order1.getT());


        //泛型参数在指明时，是不可以使用基本数据类型的，但是可以使用包装类替代基本数据类型
//        Order<int> order = new Order<>(); //错误
//        Order<Integer> order2 = new Order<>(); //正确
        Order<String> order2 = new Order<>();
        order2.setT("order2");
        order2.setOrderId(2);
        System.out.println(order2.getT());
    }

    //测试Order的子类
    @Test
    public void test2() {
        //SubOrder1不是泛型类，所以在实例化时不需要指明泛型类型
        SubOrder1 subOrder1 = new SubOrder1();

        //SubOrder2不是泛型类，所以在实例化时不需要指明泛型类型
        SubOrder2 subOrder2 = new SubOrder2();

        //SubOrder3是泛型类，所以在实例化时需要指明泛型类型
        SubOrder3<String> subOrder3 = new SubOrder3<>();
        subOrder3.show("subOrder3");

        //SubOrder4是泛型类，所以在实例化时需要指明泛型类型
        SubOrder4<String> subOrder4 = new SubOrder4<>();
        Integer t4 = subOrder4.getT();
        String e4 = subOrder4.getE();

        //SubOrder5是泛型类，所以在实例化时需要指明泛型类型
        SubOrder5<String, Integer> subOrder5 = new SubOrder5<>();
        String t5 = subOrder5.getT();
        Integer e5 = subOrder5.getE();
    }

    @Test
    public void test3() {
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        ArrayList<Integer> list = order.copyElements(arr);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
