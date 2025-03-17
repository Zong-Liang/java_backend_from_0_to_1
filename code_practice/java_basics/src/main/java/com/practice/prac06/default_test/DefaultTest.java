package com.practice.prac06.default_test;

/**
 * @author Zong Liang
 * default表示只有同一包中的类可以访问
 */
class DefaultTest {
    int defaultVariable = 10;

    void defaultMethod() {
        System.out.println("This is a default method.");
    }
}
