package com.practice.prac06.private_test;

/**
 * @author Zong Liang
 * private表示对同一类内可见，私有成员只能在声明他们的类内访问。
 */
public class PrivateTest {
    private int secretNumber = 42;

    private void privateMethod() {
        System.out.println("This is a private method.");
    }

    public void publicMethod() {
        privateMethod(); // 可以在类内部调用私有方法
    }
}
