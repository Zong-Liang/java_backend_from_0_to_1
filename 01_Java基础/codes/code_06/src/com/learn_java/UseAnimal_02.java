package com.learn_java;
/*
Java中声明的类如果没有显示的声明其父类时，则默认继承于java.lang.Object。

- Java支持多层继承。
- Java中的子父类概念是相对的。
- Java中的一个父类可以声明多个子类，反之，一个子类只能有一个父类 (Java的单继承性)。
 */

public class UseAnimal_02 {
    public void adopt(Animal_02 animal) {
        animal.eat();
        animal.jump();
    }

    public static void main(String[] args) {
        UseAnimal_02 useAnimal = new UseAnimal_02();

        //多态性
        useAnimal.adopt(new Cat_02());
        useAnimal.adopt(new Dog_02());

        //向下转型
        Animal_02 animal = new Cat_02();
        Cat_02 cat = (Cat_02) animal;
        cat.swim();
        System.out.println(cat == animal);  //true 指向堆空间中的同一个对象

        Animal_02 animal1 = new Dog_02();
        //a instanceof A : 判断对象a是否是类A的实例
        //加强代码的健壮性
        if (animal1 instanceof Animal_02) {
            Dog_02 dog = (Dog_02) animal1;
            dog.keepDoor();
            System.out.println(dog == animal1);  //true 指向堆空间中的同一个对象
        }

        System.out.println(cat.getClass().getSuperclass().getSuperclass());  //class java.lang.Object
    }
}
