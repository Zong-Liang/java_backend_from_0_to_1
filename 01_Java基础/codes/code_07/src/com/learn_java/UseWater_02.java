package com.learn_java;

public class UseWater_02 {
    public static void main(String[] args) {
        Water_02 w1 = Water_02.getInstance();
        Water_02 w2 = Water_02.getInstance();
        System.out.println(w1);
        System.out.println(w2);
        System.out.println(w1 == w2);
    }
}
