package com.learn_java.sec_02;

//在饿汉式中，实例在类加载时就被创建。
//饿汉式的优点是简单且线程安全，因为实例在类加载时就被创建。然而，它可能导致资源浪费，因为不管是否使用实例，都会创建对象。
//饿汉式：立即加载(随着类的加载，当前的唯一实例就创建了)，线程安全。

public class Water {
    //私有化构造器
    private Water(){}

    //在类内部创建当前类的实例
    //必须声明为static
    private static Water instance = new Water();

    //使用getInstance()方法获取当前类的实例，必须声明为stat
    public static Water getInstance() {
        return instance;
    }
}
