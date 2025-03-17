package com.practice.prac06.protected_test;

/**
 * @author Zong Liang
 */
public class ChildProtectedTest extends ParentProtectedTest {
    public void display() {
        System.out.println(protectedVariable); // 子类可以访问protected成员
        protectedMethod();
    }
}
