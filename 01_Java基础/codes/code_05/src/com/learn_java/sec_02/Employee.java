package com.learn_java.sec_02;

public class Employee {
    //成员变量、属性
    int id;
    String name;
    int age;
    double salary;
    Birthday birthday;

    //方法
    public void printInfo() {
        System.out.println("id: " + id + "\n" + "name: " + name + "\n" +
                "age: " + age + "\n" + "salary: " + salary + "\n" +
                "birthday: " + birthday.year +"-"+ birthday.month +"-"+ birthday.day);
    }

    public void congratulateBirthday() {
        birthday.congratulate(name);
    }
}
