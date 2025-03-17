package com.practice.prac05.interface_test;

/**
 * @author Zong Liang
 * 接口是一种完全抽象的类型，它定义了一组方法的规范，但不提供具体实现。
 * 接口中的所有方法默认是public abstract的，而接口中的变量默认是public static final的。
 */
public interface Vehicle {
    void start(); // 默认是public abstract

    void stop();

    // 默认方法（Java 8+）
    default void honk() {
        System.out.println("Beep!");
    }

    // 静态方法（Java 8+）
    static void info() {
        System.out.println("This is a Vehicle interface.");
    }
}
