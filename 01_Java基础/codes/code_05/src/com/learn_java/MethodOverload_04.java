package com.learn_java;

public class MethodOverload_04 {
    //方法的重载
    //方法名相同，参数类型或个数不同
    public void add(int i, int j) {
        System.out.println(i + j);
    }

    public void add(double i, double j) {
        System.out.println(i + j);
    }

    public void add(int i, int j, int k) {
        System.out.println(i + j + k);
    }

    public void add(String i, int j) {
        System.out.println(i + j);
    }

    public void add(int i, String j) {
        System.out.println(i + j);
    }

    //形参个数可变的方法
    public void add(int... num) {
        for (int j : num) {
            System.out.print(j + " ");
        }
    }
}
