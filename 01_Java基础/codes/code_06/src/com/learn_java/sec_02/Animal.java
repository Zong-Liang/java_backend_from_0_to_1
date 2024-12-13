package com.learn_java.sec_02;
/*
继承 (inheritance) 的基本思想是，可以基于已有的类创建新的类。继承已存在的类就是复用 (继承) 这些类的方法，而且可以增加一些新的方法和字段，使新类能够适应新的情况。
- 继承的出现减少了代码的冗余，提高了代码的复用性。
- 继承的出现，更有利于功能的扩展。
- 继承的出现让类与类之间产生了`is a`的关系，为多态的使用提供了前提。父类更通用，更一般，子类更具体。
> 不要仅为了获取其他类中的某个功能而去继承。

继承性和封装性不冲突。
*/

public class Animal {
    public void eat() {
        System.out.println("eat");
    }

    public void jump() {
        System.out.println("jump");
    }
}
