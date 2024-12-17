package com.learn_java.sec_04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class UseComparable {
    @Test
    public void test1() {
        String[] s_arr = new String[]{"Tom", "Jerry", "Jack", "Rose"};

        Arrays.sort(s_arr);

        //排序后遍历
        for (String s : s_arr) {
            System.out.println(s);
        }
    }

    @Test
    public void test2() {
        Phone[] p_arr = new Phone[5];
        p_arr[0] = new Phone("Haiwei", 6299);
        p_arr[1] = new Phone("Xiaomi", 4999);
        p_arr[2] = new Phone("Vivo", 5999);
        p_arr[3] = new Phone("Iphone", 9999);
        p_arr[4] = new Phone("Honor", 6299);

        Arrays.sort(p_arr); //ClassCastException

        for (Phone p : p_arr) {
            System.out.println(p);
        }
    }

    @Test
    public void test3() {
        Phone p1 = new Phone("Haiwei", 6299);
        Phone p2 = new Phone("Honor", 6299);

        int value = p1.compareTo(p2);
//        if (value > 0) {
//            System.out.println("p1大");
//        } else if (value == 0) {
//            System.out.println("一样大");
//        } else {
//            System.out.println("p2大");
//        }
        if (value > 0) {
            System.out.println("p1小");
        } else if (value == 0) {
            System.out.println("一样大");
        } else {
            System.out.println("p2小");
        }
    }
}
