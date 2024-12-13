package com.learn_java.sec_06;
/*
当功能内部一部分实现是确定的，另一部分是不确定的，这时可以把不确定的部分暴露出去，让子类去实现。
换句话说，在软件开发中实现一个算法时，整体步骤很固定通用，这些步骤已经在父类中写好了，但是某些部分易变，易变的部分抽象出来，供不同子类实现，这就是模版方法设计模式。
 */
public abstract class Template {
    public void runTime(){
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        System.out.println("code runtime is " + (end - start));
    }

    public abstract void code();
}
