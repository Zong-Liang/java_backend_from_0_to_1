package com.practice.prac04.runtime_polymorphism;

/**
 * @author Zong Liang
 */
public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}
