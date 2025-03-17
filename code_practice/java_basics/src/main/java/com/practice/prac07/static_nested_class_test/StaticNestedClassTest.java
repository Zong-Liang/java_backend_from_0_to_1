package com.practice.prac07.static_nested_class_test;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 */
public class StaticNestedClassTest {

    @Test
    public void test1() {
        // 静态嵌套类可以通过外部类的类名直接访问。
        OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
        nested.display(); // 输出：Static nested class accessing staticVar: 10
    }
}
