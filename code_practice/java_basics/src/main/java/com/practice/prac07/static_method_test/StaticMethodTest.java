package com.practice.prac07.static_method_test;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 */
public class StaticMethodTest {
    @Test
    public void test1() {
        int result = MathUtils.add(5, 3); // 调用静态方法
        System.out.println("Result: " + result); // 输出：Result: 8
        MathUtils.printMessage(); // 输出：This is a static method.
    }
}
