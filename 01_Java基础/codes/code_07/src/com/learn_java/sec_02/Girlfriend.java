package com.learn_java.sec_02;

//在懒汉式中，实例在第一次被使用时才被创建。
//懒汉式的优点是在第一次使用时才创建实例，避免了不必要的资源浪费。但是，在多线程环境下，需要考虑线程安全性。
//懒汉式：延迟加载(类的唯一实例在需要使用的时候进行创建)，节省内存空间。

public class Girlfriend {
    //私有化构造器
    private Girlfriend(){}

    //在类内部创建当前类的实例
    private static Girlfriend instance = null;

    //使用getInstance()方法获取当前类的实例
    public static Girlfriend getInstance() {
        if (instance == null) {
            instance = new Girlfriend();
        }
        return instance;
    }
}
