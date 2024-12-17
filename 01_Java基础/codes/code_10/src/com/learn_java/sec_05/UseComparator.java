package com.learn_java.sec_05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class UseComparator {
    @Test
    public void test1() {
        Phone[] p_arr = new Phone[5];
        p_arr[0] = new Phone("Haiwei", 6299);
        p_arr[1] = new Phone("Xiaomi", 4999);
        p_arr[2] = new Phone("Vivo", 5999);
        p_arr[3] = new Phone("Iphone", 9999);
        p_arr[4] = new Phone("Honor", 6299);

        Comparator comparator1 = new Comparator() {
            //在此方法中指明如何判断当前类的大小。
            //按照价格排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Phone && o2 instanceof Phone) {
                    Phone p1 = (Phone) o1;
                    Phone p2 = (Phone) o2;

                    return Double.compare(p1.getPrice(), p2.getPrice());

                } else {
                    throw new RuntimeException();
                }
            }
        };

        Comparator comparator2 = new Comparator() {
            //在此方法中指明如何判断当前类的大小。
            //按照名称排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Phone && o2 instanceof Phone) {
                    Phone p1 = (Phone) o1;
                    Phone p2 = (Phone) o2;

                    return p1.getName().compareTo(p2.getName());

                } else {
                    throw new RuntimeException();
                }
            }
        };

//        Arrays.sort(p_arr, comparator1);
        Arrays.sort(p_arr, comparator2);

        for (Phone p : p_arr) {
            System.out.println(p);
        }
    }

    @Test
    public void test2() {
        String[] s_arr = new String[]{"Tom", "Jerry", "Jack", "Rose"};

        //降序
        Arrays.sort(s_arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;

                    return -s1.compareTo(s2);
                } else {
                    throw new RuntimeException();
                }
            }
        });

        //排序后遍历
        for (String s : s_arr) {
            System.out.println(s);
        }
    }
}
