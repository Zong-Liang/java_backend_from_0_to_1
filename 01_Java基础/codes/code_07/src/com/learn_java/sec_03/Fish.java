package com.learn_java.sec_03;

//在Java中，代码块是一组语句的集合，用于定义特定的作用域。主要分为两种类型：实例初始化块和静态初始化块。
//实例初始化块用于初始化实例变量。它在每次创建对象时执行，位于类中方法之外，被花括号包围。
//静态初始化块用于初始化静态变量，它在类加载时执行，位于类中方法之外，使用关键字static标识。

public class Fish {

    public void eat() {
        System.out.println("Fish eat");
    }

    //代码块(可用static进行修饰)
    //静态代码块：随着类的加载只执行一次
    static {
        System.out.println("static block in Fish");
    }

    //非静态代码块：随着对象的创建而执行(每创建一次当前类的实例就会执行一次)
    {
        System.out.println("non-static block in Fish");
    }


}
