package com.learn_java.sec_02;

public class UseWater {
    public static void main(String[] args) {
        Water w1 = Water.getInstance();
        Water w2 = Water.getInstance();
        System.out.println(w1);
        System.out.println(w2);
        System.out.println(w1 == w2);
    }
}
