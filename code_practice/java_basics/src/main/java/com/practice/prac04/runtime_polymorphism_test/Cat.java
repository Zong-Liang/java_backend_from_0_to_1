package com.practice.prac04.runtime_polymorphism_test;

/**
 * @author Zong Liang
 */
public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}
