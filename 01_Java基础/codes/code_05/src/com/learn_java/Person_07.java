package com.learn_java;

public class Person_07 {
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
