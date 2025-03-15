package com.practice.prac04.compiletime_polymorphism;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 * 编译时多态主要通过方法重载（Overloading）实现。
 * 方法重载是指在同一个类中，允许定义多个同名方法，但这些方法的参数列表（参数类型、参数数量或参数顺序）必须不同。
 * 编译器在编译时根据方法的参数列表来决定调用哪个方法。
 */
public class CompileTimePolymorphismTest {
    // 方法重载：参数类型不同
    private void display(int num) {
        System.out.println("Displaying int: " + num);
    }

    // 方法重载：参数数量不同
    private void display(int num1, int num2) {
        System.out.println("Displaying int and int: " + num1 + ", " + num2);
    }

    // 方法重载：参数类型和数量都不同
    private void display(double num) {
        System.out.println("Displaying double: " + num);
    }

    @Test
    public void test1() {
        CompileTimePolymorphismTest ctp = new CompileTimePolymorphismTest();
        ctp.display(10);
        ctp.display(10, 20);
        ctp.display(10.5);

    }
}
