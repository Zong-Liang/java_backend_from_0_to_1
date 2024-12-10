package com.learn_java;

public class UsePerson_07 {
    public static void main(String[] args) {
        Person_07 person = new Person_07();
        //无法获取私有属性
        //person.age = 25;

        //调用方法操作私有属性
        person.setAge(25);
        System.out.println(person.getAge());
    }
}
