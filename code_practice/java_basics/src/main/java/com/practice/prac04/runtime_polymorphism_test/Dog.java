package com.practice.prac04.runtime_polymorphism_test;

/**
 * @author Zong Liang
 */
public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}
