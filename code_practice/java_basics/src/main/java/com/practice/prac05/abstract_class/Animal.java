package com.practice.prac05.abstract_class;

/**
 * @author Zong Liang
 */
public abstract class Animal {
    // 抽象方法
    public abstract void makeSound();

    // 具体方法
    public void eat() {
        System.out.println("Animal eats.");
    }
}
