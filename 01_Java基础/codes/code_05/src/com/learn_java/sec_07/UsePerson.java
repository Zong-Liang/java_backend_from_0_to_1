package com.learn_java.sec_07;

public class UsePerson {
    public static void main(String[] args) {
        Person person = new Person();
        //无法获取私有属性
        //person.age = 25;

        //调用方法操作私有属性
        person.setAge(25);
        System.out.println(person.getAge());
    }
}
