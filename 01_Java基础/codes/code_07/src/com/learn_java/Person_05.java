package com.learn_java;

/*
Java中规定，包含抽象方法的类必须是抽象类。
抽象类：被abstract修饰的类。
抽象方法：被abstract修饰的没有方法体的方法。
 */
public abstract class Person_05 {
    private String name;
    private int age;

    public Person_05() {
    }

    public Person_05(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract String getInfo();
}
