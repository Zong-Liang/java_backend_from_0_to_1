package com.practice.prac07.static_block_test;

/**
 * @author Zong Liang
 * 静态代码块用于初始化类的静态变量。它在类加载时执行，且只执行一次。
 */
public class StaticBlock {
    static int value;

    static {
        System.out.println("Static block executed.");
        value = 42; // 初始化静态变量
    }

    public static void main(String[] args) {
        System.out.println("Value: " + value); // 输出：Value: 42
    }
}
