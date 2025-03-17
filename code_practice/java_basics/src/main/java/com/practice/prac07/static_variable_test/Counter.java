package com.practice.prac07.static_variable_test;

/**
 * @author Zong Liang
 * 静态变量是属于类的变量，而不是属于类的某个实例。因此，静态变量在类的所有实例之间共享。
 */
public class Counter {
    public static int count = 0; // 静态变量

    public Counter() {
        count++; // 每次创建实例时，静态变量count加1
    }

    public static void displayCount() {
        System.out.println("Total instances: " + count);
    }
}
