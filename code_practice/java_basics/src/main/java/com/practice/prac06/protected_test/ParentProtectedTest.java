package com.practice.prac06.protected_test;

/**
 * @author Zong Liang
 * protected表示对同一包内的类和所有子类（无论子类是否在同一个包中）可见。
 */
public class ParentProtectedTest {
    protected int protectedVariable = 20;

    protected void protectedMethod() {
        System.out.println("This is a protected method.");
    }
}
