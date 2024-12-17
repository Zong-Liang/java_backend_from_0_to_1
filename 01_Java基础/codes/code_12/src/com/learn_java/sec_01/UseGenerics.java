package com.learn_java.sec_01;

import org.junit.jupiter.api.Test;

import java.util.*;

public class UseGenerics {
    //List中不使用泛型
    @Test
    public void test1() {
        List list = new ArrayList();
        //假设指向添加整型数据
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //类型不安全，因为add()的参数是Object类型，意味着任何类型的对象都可以添加成功。
        list.add("hello");

        for (Object o : list) {
            //需要使用强转操作，繁琐，还有可能导致CLassCastException异常。
            Integer i = (Integer) o;
            int score = i;
            System.out.println(score);
        }
    }

    //List中使用泛型
    @Test
    public void test2() {
        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

//        list.add("hello"); //编译时期就会报错

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            int score = i;
            System.out.println(score);
        }
    }

    //Map中使用泛型
    @Test
    public void test3() {
//        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //jdk7新特性：类型推断
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Tom", 87);
        map.put("Jerry", 90);
        map.put("Jack", 78);
        map.put("Rose", 99);

//        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
//        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();

        //jdk10新特性：局部变量类型推断
        var entrySet = map.entrySet();
        var iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }
}
