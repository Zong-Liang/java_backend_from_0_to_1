package com.learn_java.sec_02;
/*
Java中声明的类如果没有显示的声明其父类时，则默认继承于java.lang.Object。

- Java支持多层继承。
- Java中的子父类概念是相对的。
- Java中的一个父类可以声明多个子类，反之，一个子类只能有一个父类 (Java的单继承性)。
 */

public class UseAnimal {
    public void adopt(Animal animal) {
        animal.eat();
        animal.jump();
    }

    public static void main(String[] args) {
        UseAnimal useAnimal = new UseAnimal();

        //多态性
        useAnimal.adopt(new Cat());
        useAnimal.adopt(new Dog());

        //向下转型
        Animal animal = new Cat();
        Cat cat = (Cat) animal;
        cat.swim();
        System.out.println(cat == animal);  //true 指向堆空间中的同一个对象

        Animal animal1 = new Dog();
        //a instanceof A : 判断对象a是否是类A的实例
        //加强代码的健壮性
        if (animal1 instanceof Animal) {
            Dog dog = (Dog) animal1;
            dog.keepDoor();
            System.out.println(dog == animal1);  //true 指向堆空间中的同一个对象
        }

        System.out.println(cat.getClass().getSuperclass().getSuperclass());  //class java.lang.Object
    }
}
