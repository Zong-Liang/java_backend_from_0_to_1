package com.learn_java.sec_07;

public class Person {
    //私有属性
    private int age;

    public void setAge(int a) {
        if (a <= 0 || a >= 130) {
            System.out.println("the age you input is illegal.");
        } else {
            age = a;
        }
    }

    public int getAge() {
        return age;
    }
}
