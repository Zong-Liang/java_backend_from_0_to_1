package com.practice.prac04.runtime_polymorphism;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 * 运行时多态主要通过方法覆盖（Overriding）实现。
 * 方法覆盖是指在子类中重写父类的同名方法（方法名、参数列表和返回值类型都相同）。
 * 运行时多态的核心在于动态绑定（Dynamic Binding），即在运行时根据对象的实际类型来调用相应的方法。
 */
public class RunTimePolymorphismTest {
    @Test
    public void test1() {
        Animal myAnimal;

        myAnimal = new Dog();
        myAnimal.makeSound(); // 输出：Dog barks

        myAnimal = new Cat();
        myAnimal.makeSound(); // 输出：Cat meows

    }
}
