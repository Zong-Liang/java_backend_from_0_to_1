package com.practice.prac05.abstract_class;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 */
public class AbstractClassTest {
    @Test
    public void test1() {
        Dog dog = new Dog();
        dog.makeSound(); // 输出：Dog barks.
        dog.eat(); // 输出：Animal eats.
    }
}
