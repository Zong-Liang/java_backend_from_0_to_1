package com.practice.prac07.static_method_test;

/**
 * @author Zong Liang
 * 静态方法是属于类的方法，而不是属于类的某个实例。因此，静态方法可以在不创建类实例的情况下直接调用。
 */
public class MathUtils {
    public static int add(int a, int b) {
        return a + b;
    }

    public static void printMessage() {
        System.out.println("This is a static method.");
    }
}
