package com.practice.prac07.static_nested_class_test;

/**
 * @author Zong Liang
 * 静态嵌套类是定义在另一个类内部的类，但它不属于外部类的某个实例。
 */
public class OuterClass {
    public static int staticVar = 10;

    public static class StaticNestedClass {
        public void display() {
            System.out.println("Static nested class accessing staticVar: " + staticVar);
        }
    }
}
